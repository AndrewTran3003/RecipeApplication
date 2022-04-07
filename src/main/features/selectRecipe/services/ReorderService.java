package features.selectRecipe.services;

import models.fridge.Fridge;
import models.fridge.Item;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ReorderService {
    public Recipes reorderRecipeList(ArrayList<Recipe> recipeList, Fridge fridge) {
        Fridge sortedFridge = reorderItemsInFridge(fridge);
        ArrayList<Recipe> sortedRecipeList = reorderRecipeList(recipeList,0,sortedFridge.getItems());
        Recipes result = new Recipes();
        result.setRecipes(sortedRecipeList);
        return result;
    }
    private ArrayList<Recipe> reorderRecipeList(ArrayList<Recipe>recipes, int index, ArrayList<Item> items){
        ArrayList<Recipe> result = new ArrayList<>();
        for(int i = index; i < items.size();i++){
            ArrayList<Recipe> matchedRecipes = findRecipesWithItem(recipes,items.get(i));
            if (multipleRecipesWithItem(matchedRecipes)){
                result.addAll(reorderRecipeList(matchedRecipes,i + 1,items));
            }
            else{
                addRecipeToList(matchedRecipes.get(0),result);
            }
        }
        if (recipesNotChosenExist(recipes)) {
            addAllNotChosenRecipesToList(getNotChosenRecipes(recipes), result);
        }
        return result;
    }
    private boolean multipleRecipesWithItem(ArrayList<Recipe> matchedRecipes){
        return matchedRecipes.size() != 1;
    }
    private void addRecipeToList(Recipe recipe, ArrayList<Recipe> recipeList){
        recipe.setChosen(true);
        recipeList.add(recipe);
    }
    private void addAllNotChosenRecipesToList(ArrayList<Recipe> notChosenRecipes, ArrayList<Recipe> result){
        notChosenRecipes.forEach(recipe -> addRecipeToList(recipe,result));
    }
    private ArrayList<Recipe> getNotChosenRecipes(ArrayList<Recipe> recipes) {
        return new ArrayList<>(recipes.stream().filter(recipe -> isRecipeNotChosen(recipe))
                .collect(Collectors.toList()));
    }

    private boolean recipesNotChosenExist(ArrayList<Recipe> recipes) {
        return recipes.stream().anyMatch(recipe -> isRecipeNotChosen(recipe));
    }
    private boolean isRecipeNotChosen(Recipe recipe){
        return !recipe.getChosen();
    }

    private ArrayList<Recipe> findRecipesWithItem(ArrayList<Recipe> recipeList, Item item){
        return new ArrayList<>(
                recipeList.stream()
                        .filter(recipe ->
                                isRecipeNotChosen(recipe)
                                        && recipe.getIngredients()
                                        .stream()
                                        .anyMatch(ingredient -> ingredient.getItem() == item.getItem()))
                        .collect(Collectors.toList()));
    }

    public Fridge reorderItemsInFridge(Fridge fridge){
        Fridge fridgeWithSortedItems = new Fridge();
        ArrayList<Item> sortedItems = new ArrayList<>(fridge.getItems().stream().sorted(Comparator.comparing(Item::getUseBy)).collect(Collectors.toList()));
        fridgeWithSortedItems.setItems(sortedItems);
        return fridgeWithSortedItems;
    }
}
