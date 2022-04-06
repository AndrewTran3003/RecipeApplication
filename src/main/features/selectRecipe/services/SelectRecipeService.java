package features.selectRecipe.services;

import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import models.fridge.Fridge;
import models.fridge.Item;
import models.recipeList.Ingredient;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class SelectRecipeService {
    public OperationResultMessage<ArrayList<Recipe>> findRecipe(Fridge fridge, Recipes recipeList) {
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe recipe : recipeList.getRecipes()) {
            if (canPrepareRecipe(recipe, fridge)) {
                result.add(recipe);
            }
        }
        if (result.size() == 0) {
            return new OperationResultMessage<>(OperationResultStatus.EMPTY, StringHelper.EMPTY_STRING, null);
        }
        return new OperationResultMessage<>(OperationResultStatus.SUCCESS, StringHelper.EMPTY_STRING, result);
    }

    private boolean canPrepareRecipe(Recipe recipe, Fridge fridge) {
        for (Ingredient ingredient : recipe.getIngredients()) {
            if (fridge.getItems().stream().anyMatch(item -> matchName(item, ingredient) && enoughAmount(item, ingredient) && hasNotPassTheDueDate(item))) {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean matchName(Item item, Ingredient ingredient) {
        return item.getItem() == ingredient.getItem();
    }

    private boolean enoughAmount(Item item, Ingredient ingredient) {
        return item.getAmount() >= ingredient.getAmount();
    }

    private boolean hasNotPassTheDueDate(Item item) {
        return LocalDate.now().isBefore(item.getUseBy());
    }
}
