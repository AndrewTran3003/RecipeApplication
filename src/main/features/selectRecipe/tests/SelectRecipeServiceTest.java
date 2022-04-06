import features.selectRecipe.services.SelectRecipeService;
import models.OperationResultMessage;
import models.OperationResultStatus;
import models.fridge.Fridge;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import testData.selectRecipesTestData;

import java.util.ArrayList;

@SpringBootTest(classes = SelectRecipeServiceTest.class)
public class SelectRecipeServiceTest {
    @Test
    public void canFindRecipe() {
        SelectRecipeService service = new SelectRecipeService();
        Fridge fridge = selectRecipesTestData.getFridgeData();
        Recipes recipeList = selectRecipesTestData.getRecipeList();
        OperationResultMessage<ArrayList<Recipe>> selectedRecipeResult = service.findRecipe(fridge, recipeList);
        Assertions.assertEquals(OperationResultStatus.SUCCESS, selectedRecipeResult.getStatus());
        Assertions.assertEquals(1, selectedRecipeResult.getResult().size());

    }

    @Test
    public void canFindRecipes() {
        SelectRecipeService service = new SelectRecipeService();
        Fridge fridge = selectRecipesTestData.getFridgeData2();
        Recipes recipeList = selectRecipesTestData.getRecipeList2();
        OperationResultMessage<ArrayList<Recipe>> selectedRecipeResult = service.findRecipe(fridge, recipeList);
        Assertions.assertEquals(OperationResultStatus.SUCCESS, selectedRecipeResult.getStatus());
        Assertions.assertEquals(2, selectedRecipeResult.getResult().size());
    }

    @Test
    public void cannotFindRecipe() {
        SelectRecipeService service = new SelectRecipeService();
        Fridge fridge = selectRecipesTestData.getFridgeData3();
        Recipes recipeList = selectRecipesTestData.getRecipeList2();
        OperationResultMessage<ArrayList<Recipe>> selectedRecipeResult = service.findRecipe(fridge, recipeList);
        Assertions.assertEquals(OperationResultStatus.EMPTY, selectedRecipeResult.getStatus());
        Assertions.assertEquals(null, selectedRecipeResult.getResult());
    }


}
