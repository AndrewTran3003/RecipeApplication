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
        ArrayList<Recipe> sortedRecipeList = new ArrayList<>();
        for(Item item : sortedFridge.getItems()){
            int index = sortedFridge.getItems().indexOf(item);
            Recipe matchingRecipe = findRecipe(recipeList,index,sortedFridge.getItems());
            if (matchingRecipe != null){
                sortedRecipeList.add(matchingRecipe);
            }

        }
        Recipes result = new Recipes();
        result.setRecipes(sortedRecipeList);
        return result;
    }

    private Recipe findRecipe(ArrayList<Recipe> recipeList, int index, ArrayList<Item> items) {
        if (index > items.size() - 1){
            return null;
        }
        List<Recipe> filteredRecipeList = recipeList.stream().filter(recipe -> !recipe.getChosen() && recipe.getIngredients().stream().anyMatch(ingredient -> ingredient.getItem() == items.get(index).getItem())).collect(Collectors.toList());
        if (filteredRecipeList.size() == 1){
            filteredRecipeList.get(0).setChosen(true);
            return filteredRecipeList.get(0);
        }
        return findRecipe(recipeList,index + 1, items);
    }

    public Fridge reorderItemsInFridge(Fridge fridge){
        Fridge fridgeWithSortedItems = new Fridge();
        ArrayList<Item> sortedItems = new ArrayList<>(fridge.getItems().stream().sorted(Comparator.comparing(Item::getUseBy)).collect(Collectors.toList()));
        fridgeWithSortedItems.setItems(sortedItems);
        return fridgeWithSortedItems;
    }
}
