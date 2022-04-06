package features.selectRecipe.services;

import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import models.fridge.Fridge;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.springframework.stereotype.Service;

@Service
public class SelectRecipeService {
    public OperationResultMessage<Recipe> findRecipe(Fridge fridge, Recipes recipeList) {
        return new OperationResultMessage<>(OperationResultStatus.SUCCESS, StringHelper.EMPTY_STRING,null);
    }
}
