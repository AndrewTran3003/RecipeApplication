package testData;

import models.IngredientUnit;
import models.fridge.Fridge;
import models.fridge.Item;
import models.recipeList.Ingredient;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class selectRecipesTestData {
    public static Recipes getRecipeList() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(getGrilledCheeseOnToast());
        recipes.add(getSaladSandwich());
        Recipes result = new Recipes();
        result.setRecipes(recipes);
        return result;
    }

    public static Recipes getRecipeList2() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(getHamAndCheeseToastie());
        recipes.add(getChickenSalad());
        recipes.add(getScrambledEgg());

        Recipes result = new Recipes();
        result.setRecipes(recipes);
        return result;
    }
    public static Recipe getHamAndCheeseToastie() {
        return new Recipe("hamandcheesetoastie", getHamAndCheeseToastieIngredients());
    }

    private static Recipe getChickenSalad() {
        return new Recipe("chickensalad", getChickenSaladIngredients());
    }


    public static @NotNull Recipe getSaladSandwich() {
        return new Recipe("saladsandwich", getSaladSandwichIngredients());
    }

    private static Recipe getGrilledCheeseOnToast() {
        return new Recipe("grilledcheeseontoast", getGrilledCheeseOnToastIngredients());
    }

    public static Recipe getScrambledEgg() {
        return new Recipe("scrambledegg", getScrambledEggIngredients());
    }
    public static Recipe getPeanutButterChickenNugget(){
        return new Recipe("peanutbutterchickennugget",getPeanutButterChickenNuggetIngredients());
    }

    private static ArrayList<Ingredient> getPeanutButterChickenNuggetIngredients() {
        Ingredient peanutButter = new Ingredient("peanut butter", 200, IngredientUnit.GRAMS);
        Ingredient chickenNugget = new Ingredient("chicken", 10, IngredientUnit.SLICES);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(peanutButter);
        result.add(chickenNugget);
        return result;
    }

    private static ArrayList<Ingredient> getScrambledEggIngredients() {
        Ingredient cheese = new Ingredient("cheese", 2, IngredientUnit.SLICES);
        Ingredient eggs = new Ingredient("egg", 4, IngredientUnit.OF);
        Ingredient bread = new Ingredient("bread",2,IngredientUnit.SLICES);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(cheese);
        result.add(eggs);
        result.add(bread);
        return result;
    }

    private static ArrayList<Ingredient> getChickenSaladIngredients() {
        Ingredient mixedSalad = new Ingredient("mixed salad", 200, IngredientUnit.GRAMS);
        Ingredient chicken = new Ingredient("chicken", 300, IngredientUnit.GRAMS);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(mixedSalad);
        result.add(chicken);
        return result;
    }

    private static ArrayList<Ingredient> getHamAndCheeseToastieIngredients() {
        Ingredient bread = new Ingredient("bread", 2, IngredientUnit.SLICES);
        Ingredient ham = new Ingredient("ham", 2, IngredientUnit.SLICES);
        Ingredient cheese = new Ingredient("cheese", 2, IngredientUnit.SLICES);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(bread);
        result.add(ham);
        result.add(cheese);
        return result;
    }

    private static ArrayList<Ingredient> getSaladSandwichIngredients() {
        Ingredient bread = new Ingredient("bread", 2, IngredientUnit.SLICES);
        Ingredient mixedSalad = new Ingredient("mixed salad", 200, IngredientUnit.GRAMS);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(bread);
        result.add(mixedSalad);
        return result;
    }


    private static ArrayList<Ingredient> getGrilledCheeseOnToastIngredients() {
        Ingredient bread = new Ingredient("bread", 2, IngredientUnit.SLICES);
        Ingredient cheese = new Ingredient("cheese", 2, IngredientUnit.SLICES);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(bread);
        result.add(cheese);
        return result;
    }

    public static Fridge getFridgeData() {
        Fridge result = new Fridge();
        result.setItems(GetItemList());
        return result;
    }

    public static Fridge getFridgeData2() {
        Fridge result = new Fridge();
        result.setItems(GetItemList2());
        return result;
    }

    public static Fridge getFridgeData3() {
        Fridge result = new Fridge();
        result.setItems(new ArrayList<>());
        return result;
    }

    private static ArrayList<Item> GetItemList2() {
        ArrayList<Item> result = new ArrayList<>();
        Item bread = new Item("bread", 10, IngredientUnit.SLICES, LocalDate.now().plusDays(3));
        Item cheese = new Item("cheese", 10, IngredientUnit.SLICES, LocalDate.now().plusDays(5));
        Item butter = new Item("butter", 250, IngredientUnit.GRAMS, LocalDate.now().plusDays(4));
        Item peanutButter = new Item("peanut butter", 250, IngredientUnit.GRAMS, LocalDate.now().plusYears(2));
        Item mixedSalad = new Item("mixed salad", 500, IngredientUnit.GRAMS, LocalDate.now().plusDays(2));
        Item ham = new Item("ham", 2, IngredientUnit.SLICES, LocalDate.now().plusDays(6));
        Item eggs = new Item("egg", 5, IngredientUnit.OF, LocalDate.now().plusDays(7));
        Item chicken = new Item("chicken", 300, IngredientUnit.GRAMS, LocalDate.now().minusDays(2));
        Item chickenNugget = new Item("chicken nugget", 30, IngredientUnit.SLICES, LocalDate.now().plusDays(1));

        result.add(bread);
        result.add(cheese);
        result.add(butter);
        result.add(peanutButter);
        result.add(mixedSalad);
        result.add(ham);
        result.add(chicken);
        result.add(eggs);
        result.add(chickenNugget);
        return result;
    }

    private static ArrayList<Item> GetItemList() {
        ArrayList<Item> result = new ArrayList<>();
        Item bread = new Item("bread", 10, IngredientUnit.SLICES, LocalDate.now().plusDays(3));
        Item cheese = new Item("cheese", 10, IngredientUnit.SLICES, LocalDate.now().minusDays(5));
        Item butter = new Item("butter", 250, IngredientUnit.GRAMS, LocalDate.now().plusMonths(3));
        Item peanutButter = new Item("peanut butter", 250, IngredientUnit.GRAMS, LocalDate.now().plusYears(2));
        Item mixedSalad = new Item("mixed salad", 500, IngredientUnit.GRAMS, LocalDate.now().plusDays(2));
        result.add(bread);
        result.add(cheese);
        result.add(butter);
        result.add(peanutButter);
        result.add(mixedSalad);
        return result;
    }
}
