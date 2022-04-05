package features.readRecipes.helpers;

import com.google.gson.reflect.TypeToken;
import features.readRecipes.models.Recipe;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TypeHelper {
    public static Type RECIPE_LIST = new TypeToken<ArrayList<Recipe>>(){}.getType();

}
