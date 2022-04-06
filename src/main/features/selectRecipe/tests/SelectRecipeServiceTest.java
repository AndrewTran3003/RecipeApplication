import features.selectRecipe.services.SelectRecipeService;
import models.IngredientUnit;
import models.OperationResultMessage;
import models.OperationResultStatus;
import models.fridge.Fridge;
import models.fridge.Item;
import models.recipeList.Ingredient;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootTest(classes = SelectRecipeServiceTest.class)
public class SelectRecipeServiceTest {
    @Test
    public void canFindRecipe() {
        SelectRecipeService service = new SelectRecipeService();
        Fridge fridge = getFridgeData();
        Recipes recipeList = getRecipeList();
        OperationResultMessage<ArrayList<Recipe>> selectedRecipeResult = service.findRecipe(fridge, recipeList);
        Assertions.assertEquals(OperationResultStatus.SUCCESS, selectedRecipeResult.getStatus());
        Assertions.assertEquals(1, selectedRecipeResult.getResult().size());

    }

    @Test
    public void canFindRecipes() {
        SelectRecipeService service = new SelectRecipeService();
        Fridge fridge = getFridgeData2();
        Recipes recipeList = getRecipeList2();
        OperationResultMessage<ArrayList<Recipe>> selectedRecipeResult = service.findRecipe(fridge, recipeList);
        Assertions.assertEquals(OperationResultStatus.SUCCESS, selectedRecipeResult.getStatus());
        Assertions.assertEquals(2, selectedRecipeResult.getResult().size());
    }

    @Test
    public void cannotFindRecipe() {
        SelectRecipeService service = new SelectRecipeService();
        Fridge fridge = getFridgeData3();
        Recipes recipeList = getRecipeList2();
        OperationResultMessage<ArrayList<Recipe>> selectedRecipeResult = service.findRecipe(fridge, recipeList);
        Assertions.assertEquals(OperationResultStatus.EMPTY, selectedRecipeResult.getStatus());
        Assertions.assertEquals(null, selectedRecipeResult.getResult());
    }


    private Recipes getRecipeList() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(getGrilledCheeseOnToast());
        recipes.add(getSaladSandwich());
        Recipes result = new Recipes();
        result.setRecipes(recipes);
        return result;
    }

    private Recipes getRecipeList2() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(getHamAndCheeseToastie());
        recipes.add(getChickenSalad());
        recipes.add(getScrambledEgg());

        Recipes result = new Recipes();
        result.setRecipes(recipes);
        return result;
    }

    private Recipe getHamAndCheeseToastie() {
        return new Recipe("hamandcheesetoastie", getHamAndCheeseToastieIngredients());
    }

    private Recipe getChickenSalad() {
        return new Recipe("chickensalad", getChickenSaladIngredients());
    }


    private @NotNull Recipe getSaladSandwich() {
        return new Recipe("saladsandwich", getSaladSandwichIngredients());
    }

    private Recipe getGrilledCheeseOnToast() {
        return new Recipe("grilledcheeseontoast", getGrilledCheeseOnToastIngredients());
    }

    private Recipe getScrambledEgg() {
        return new Recipe("scrambledegg", getScrambledEggIngredients());
    }

    private ArrayList<Ingredient> getScrambledEggIngredients() {
        Ingredient cheese = new Ingredient("cheese", 2, IngredientUnit.SLICES);
        Ingredient eggs = new Ingredient("egg", 4, IngredientUnit.OF);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(cheese);
        result.add(eggs);
        return result;
    }

    private ArrayList<Ingredient> getChickenSaladIngredients() {
        Ingredient mixedSalad = new Ingredient("mixed salad", 200, IngredientUnit.GRAMS);
        Ingredient chicken = new Ingredient("chicken", 300, IngredientUnit.GRAMS);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(mixedSalad);
        result.add(chicken);
        return result;
    }

    private ArrayList<Ingredient> getHamAndCheeseToastieIngredients() {
        Ingredient bread = new Ingredient("bread", 2, IngredientUnit.SLICES);
        Ingredient ham = new Ingredient("ham", 2, IngredientUnit.SLICES);
        Ingredient cheese = new Ingredient("cheese", 2, IngredientUnit.SLICES);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(bread);
        result.add(ham);
        result.add(cheese);
        return result;
    }

    private ArrayList<Ingredient> getSaladSandwichIngredients() {
        Ingredient bread = new Ingredient("bread", 2, IngredientUnit.SLICES);
        Ingredient mixedSalad = new Ingredient("mixed salad", 200, IngredientUnit.GRAMS);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(bread);
        result.add(mixedSalad);
        return result;
    }


    private ArrayList<Ingredient> getGrilledCheeseOnToastIngredients() {
        Ingredient bread = new Ingredient("bread", 2, IngredientUnit.SLICES);
        Ingredient cheese = new Ingredient("cheese", 2, IngredientUnit.SLICES);
        ArrayList<Ingredient> result = new ArrayList<>();
        result.add(bread);
        result.add(cheese);
        return result;
    }

    private Fridge getFridgeData() {
        Fridge result = new Fridge();
        result.setItems(GetItemList());
        return result;
    }

    private Fridge getFridgeData2() {
        Fridge result = new Fridge();
        result.setItems(GetItemList2());
        return result;
    }

    private Fridge getFridgeData3() {
        Fridge result = new Fridge();
        result.setItems(new ArrayList<>());
        return result;
    }

    private ArrayList<Item> GetItemList2() {
        ArrayList<Item> result = new ArrayList<>();
        Item bread = new Item("bread", 10, IngredientUnit.SLICES, LocalDate.now().plusDays(3));
        Item cheese = new Item("cheese", 10, IngredientUnit.SLICES, LocalDate.now().plusDays(5));
        Item butter = new Item("butter", 250, IngredientUnit.GRAMS, LocalDate.now().plusMonths(3));
        Item peanutButter = new Item("peanut butter", 250, IngredientUnit.GRAMS, LocalDate.now().plusYears(2));
        Item mixedSalad = new Item("mixed salad", 500, IngredientUnit.GRAMS, LocalDate.now().plusDays(2));
        Item ham = new Item("ham", 2, IngredientUnit.SLICES, LocalDate.now().plusDays(5));
        Item eggs = new Item("egg", 5, IngredientUnit.OF, LocalDate.now().plusDays(7));
        Item chicken = new Item("chicken", 300, IngredientUnit.GRAMS, LocalDate.now().minusDays(2));

        result.add(bread);
        result.add(cheese);
        result.add(butter);
        result.add(peanutButter);
        result.add(mixedSalad);
        result.add(ham);
        result.add(chicken);
        result.add(eggs);
        return result;
    }

    private ArrayList<Item> GetItemList() {
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
