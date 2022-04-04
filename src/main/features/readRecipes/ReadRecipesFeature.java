package features.readRecipes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import features.readFile.ReadFileFeature;
import features.readRecipes.models.Recipe;
import features.readRecipes.models.Recipes;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ReadRecipesFeature {
    private final ReadFileFeature readFileFeature;
    public ReadRecipesFeature(ReadFileFeature readFileFeature){
        this.readFileFeature = readFileFeature;
    }
    public OperationResultMessage<Recipes> getRecipes(){
        OperationResultMessage<String> recipesStringMessage = readFileFeature.readToString("src\\main\\data\\recipes.json");
        if (recipesStringMessage.getStatus() != OperationResultStatus.SUCCESS){
            return new OperationResultMessage<>(OperationResultStatus.ERROR,recipesStringMessage.getMessage(),null);
        }
        String recipesString = recipesStringMessage.getResult();

        try{
            Type recipeListType = new TypeToken<ArrayList<Recipe>>(){}.getType();
            Gson converter = new Gson();
            ArrayList<Recipe> recipeList = converter.fromJson(recipesString,recipeListType);
            Recipes result = new Recipes();
            result.setRecipes(recipeList);
            return new OperationResultMessage<>(OperationResultStatus.SUCCESS, StringHelper.EMPTY_STRING,result);
        }
       catch (Exception e){
            return new OperationResultMessage<>(OperationResultStatus.ERROR,e.getCause().getMessage(),null);
       }
    }
}
