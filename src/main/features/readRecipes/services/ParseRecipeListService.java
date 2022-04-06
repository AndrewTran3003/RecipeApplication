package features.readRecipes.services;

import com.google.gson.Gson;
import features.readRecipes.helpers.ResultHelper;
import features.readRecipes.helpers.TypeHelper;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import models.OperationResultMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ParseRecipeListService {

    public OperationResultMessage<Recipes> Parse(String recipeListString){
        try{
            Gson converter = new Gson();
            ArrayList<Recipe> recipeList = converter.fromJson(recipeListString, TypeHelper.RECIPE_LIST);
            Recipes result = new Recipes();
            result.setRecipes(recipeList);
            return ResultHelper.successResult(result);
        }
        catch (Exception e){
            return ResultHelper.errorResult(e.getMessage());
        }
    }

}
