package features.selectRecipe;

import features.readFridge.ReadFridgeFeature;
import features.readRecipes.ReadRecipesFeature;
import features.selectRecipe.services.ReorderService;
import features.selectRecipe.services.SelectRecipeService;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import models.fridge.Fridge;
import models.recipeList.Recipe;
import models.recipeList.Recipes;

import java.util.ArrayList;

public class SelectRecipeFeature {
    private final ReadFridgeFeature readFridgeFeature;
    private final ReadRecipesFeature readRecipesFeature;
    private final ReorderService reorderService;
    private final SelectRecipeService selectRecipeService;

    public SelectRecipeFeature(ReadFridgeFeature readFridgeFeature,
                               ReadRecipesFeature readRecipesFeature,
                               ReorderService reorderService,
                               SelectRecipeService selectRecipeService) {
        this.readFridgeFeature = readFridgeFeature;
        this.readRecipesFeature = readRecipesFeature;
        this.reorderService = reorderService;
        this.selectRecipeService = selectRecipeService;
    }

    public OperationResultMessage<Recipes> getAvailableRecipes() {
        OperationResultMessage<Fridge> fridgeReadingMessage = readFridgeFeature.getFridgeItems();
        if (fridgeReadingMessage.getStatus() != OperationResultStatus.SUCCESS) {
            return new OperationResultMessage<>(OperationResultStatus.ERROR, fridgeReadingMessage.getMessage(), null);
        }
        OperationResultMessage<Recipes> recipeListReadingMessage = readRecipesFeature.getRecipes();
        if (recipeListReadingMessage.getStatus() != OperationResultStatus.SUCCESS) {
            return new OperationResultMessage<>(OperationResultStatus.ERROR, recipeListReadingMessage.getMessage(), null);
        }
        OperationResultMessage<ArrayList<Recipe>> recipeListMessage = selectRecipeService.findRecipe(fridgeReadingMessage.getResult(), recipeListReadingMessage.getResult());
        if (recipeListMessage.getStatus() == OperationResultStatus.SUCCESS) {
            Recipes sortedRecipeList = reorderService.reorderRecipeList(recipeListMessage.getResult(), fridgeReadingMessage.getResult());
            return new OperationResultMessage<>(OperationResultStatus.SUCCESS, StringHelper.EMPTY_STRING, sortedRecipeList);
        }
        if (recipeListMessage.getStatus() == OperationResultStatus.EMPTY) {
            return new OperationResultMessage<>(OperationResultStatus.EMPTY, "Order Takeout", null);
        }
        return new OperationResultMessage<>(OperationResultStatus.ERROR, recipeListMessage.getMessage(), null);
    }
}
