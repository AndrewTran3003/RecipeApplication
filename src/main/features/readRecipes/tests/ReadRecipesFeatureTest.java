import features.readFile.ReadFileFeature;
import features.readRecipes.ReadRecipesFeature;
import features.readRecipes.models.Recipes;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = ReadRecipesFeatureTest.class)
public class ReadRecipesFeatureTest {
    @Test
    public void canReadRecipeList(){
        ReadFileFeature readFileFeature = new ReadFileFeature();
        ReadRecipesFeature feature = new ReadRecipesFeature(readFileFeature);
        OperationResultMessage<Recipes> recipeList = feature.getRecipes();
        Assertions.assertEquals(StringHelper.EMPTY_STRING, recipeList.getMessage());
        Assertions.assertEquals(OperationResultStatus.SUCCESS, recipeList.getStatus());
        Assertions.assertNotEquals(0, recipeList.getResult().getRecipes().size());

    }

}
