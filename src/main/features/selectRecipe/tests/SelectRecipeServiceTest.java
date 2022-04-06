import features.selectRecipe.services.SelectRecipeService;
import models.OperationResultMessage;
import models.OperationResultStatus;
import models.fridge.Fridge;
import models.recipeList.Recipe;
import models.recipeList.Recipes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SelectRecipeServiceTest.class)
public class SelectRecipeServiceTest {
    @Test
    public void canFindRecipe(){
        SelectRecipeService service = new SelectRecipeService();
        Fridge fridge = getFridgeData();
        Recipes recipeList = getRecipeList();
        OperationResultMessage<Recipe> selectedRecipeResult = service.findRecipe(fridge,recipeList);
        Assertions.assertEquals(OperationResultStatus.SUCCESS, selectedRecipeResult.getStatus());
        Assertions.assertNotEquals(null, selectedRecipeResult.getResult());

    }

    private Recipes getRecipeList() {
        return null;
    }

    private Fridge getFridgeData() {
        return null;
    }
}
