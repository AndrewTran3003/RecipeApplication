import models.recipeList.Recipes;
import features.readRecipes.services.ParseRecipeListService;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ParseRecipeListServiceTest.class)
public class ParseRecipeListServiceTest {
    @Test
    public void canParseRecipeList() {
        ParseRecipeListService parseRecipeListService = new ParseRecipeListService();
        String input = "[\n" +
                "  {\n" +
                "    \"name\":\"grilledcheeseontoast\",\n" +
                "    \"ingredients\":[\n" +
                "      {\"item\":\"bread\",\"amount\":\"2\",\"unit\":\"slices\"},\n" +
                "      {\"item\":\"cheese\",\"amount\":\"2\",\"unit\":\"slices\"}\n" +
                "    ]\n" +
                "  }\n" +
                ",\n" +
                "  {\n" +
                "    \"name\":\"saladsandwich\",\n" +
                "    \"ingredients\":[\n" +
                "      {\"item\":\"bread\",\"amount\":\"2\",\"unit\":\"slices\"},\n" +
                "      {\"item\":\"mixed salad\",\"amount\":\"200\",\"unit\":\"grams\"}\n" +
                "    ]\n" +
                "  }\n" +
                "] \n";
        OperationResultMessage<Recipes> result = parseRecipeListService.Parse(input);
        Assertions.assertEquals(OperationResultStatus.SUCCESS, result.getStatus());
        Assertions.assertEquals(StringHelper.EMPTY_STRING, result.getMessage());
        Assertions.assertNotEquals(0, result.getResult().getRecipes().size());
    }

    @Test
    public void cannotParseRecipeList() {
        ParseRecipeListService parseRecipeListService = new ParseRecipeListService();
        String input = "[\n" +
                "  {\n" +
                "    \"name\":\"grilledcheeseontoast\",\n" +
                "    ";
        OperationResultMessage<Recipes> result = parseRecipeListService.Parse(input);
        Assertions.assertEquals(OperationResultStatus.ERROR, result.getStatus());

    }
}
