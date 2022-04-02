import features.readFile.ReadFileFeature;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ReadFileFeature.class)
public class ReadFileFeatureTest {
    @Test
    void canReadFile(){
        ReadFileFeature readFileFeature = new ReadFileFeature();
        OperationResultMessage<Object> readResult = readFileFeature.read("D:\\SideProjects\\RecipeApplication\\src\\main\\data\\recipe.");
        Assertions.assertEquals(readResult.getStatus(), OperationResultStatus.SUCCESS);
    }
}
