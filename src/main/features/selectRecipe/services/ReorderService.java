package features.selectRecipe.services;

import models.fridge.Fridge;
import models.fridge.Item;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
            ArrayList<Recipe> matched = findRecipesWithItem(recipes,items.get(i));
            if (matched.size() == 1){
                matched.get(0).setChosen(true);
                result.add(matched.get(0));
            }
            else{
                result.addAll(reorderRecipeList(matched,i + 1,items));
            }
        }
        return result;
    }
    private ArrayList<Recipe> findRecipesWithItem(ArrayList<Recipe> recipeList, Item item){
        return new ArrayList<>(
                recipeList.stream()
                        .filter(recipe ->
                                !recipe.getChosen()
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
