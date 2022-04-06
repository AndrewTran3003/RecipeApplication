import features.selectRecipe.services.ReorderService;
import models.fridge.Fridge;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import testData.selectRecipesTestData;

import java.util.ArrayList;
@SpringBootTest(classes = ReorderServiceTest.class)
public class ReorderServiceTest {
    @Test
    public void TestReorderRecipes(){
        ReorderService service = new ReorderService();
        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(selectRecipesTestData.getScrambledEgg());
        recipeList.add(selectRecipesTestData.getHamAndCheeseToastie());
        recipeList.add(selectRecipesTestData.getPeanutButterChickenNugget());
        recipeList.add(selectRecipesTestData.getSaladSandwich());
        Fridge fridge = selectRecipesTestData.getFridgeData2();
        Recipes reorderedRecipeList = service.reorderRecipeList(recipeList,fridge);
        Assertions.assertEquals(4, reorderedRecipeList.getRecipes().size());
        Assertions.assertEquals("peanutbutterchickennugget",reorderedRecipeList.getRecipes().get(0).getName());
        Assertions.assertEquals("saladsandwich",reorderedRecipeList.getRecipes().get(1).getName());
        Assertions.assertEquals("hamandcheesetoastie",reorderedRecipeList.getRecipes().get(2).getName());
        Assertions.assertEquals("scrambledegg",reorderedRecipeList.getRecipes().get(3).getName());
    }

    @Test
    public void TestReorderFridge(){
        ReorderService service =new ReorderService();
        Fridge fridge = selectRecipesTestData.getFridgeData2();
        Fridge fridgeWithItemsReordered = service.reorderItemsInFridge(fridge);
        Assertions.assertEquals("chicken",fridgeWithItemsReordered.getItems().get(0).getItem());
        Assertions.assertEquals("chicken nugget",fridgeWithItemsReordered.getItems().get(1).getItem());
        Assertions.assertEquals("mixed salad",fridgeWithItemsReordered.getItems().get(2).getItem());
        Assertions.assertEquals("bread",fridgeWithItemsReordered.getItems().get(3).getItem());
        Assertions.assertEquals("butter",fridgeWithItemsReordered.getItems().get(4).getItem());
        Assertions.assertEquals("cheese",fridgeWithItemsReordered.getItems().get(5).getItem());
        Assertions.assertEquals("ham",fridgeWithItemsReordered.getItems().get(6).getItem());
        Assertions.assertEquals("egg",fridgeWithItemsReordered.getItems().get(7).getItem());
        Assertions.assertEquals("peanut butter",fridgeWithItemsReordered.getItems().get(8).getItem());

    }
}
