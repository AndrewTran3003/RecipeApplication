import features.selectRecipe.services.SelectRecipeService;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SelectRecipeServiceTest.class)
public class SelectRecipeServiceTest {
    public void canFindRecipe(){
        SelectRecipeService service = new SelectRecipeService();

    }
}
