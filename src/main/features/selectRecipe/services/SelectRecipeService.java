package features.selectRecipe.services;

import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import models.fridge.Fridge;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SelectRecipeService {
    public OperationResultMessage<ArrayList<Recipe>> findRecipe(Fridge fridge, Recipes recipeList) {
        return new OperationResultMessage<>(OperationResultStatus.SUCCESS, StringHelper.EMPTY_STRING,new ArrayList<>());
    }
}
