import features.readFile.ReadFileFeature;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import features.readFile.helpers.readFileHelpers;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=ReadFileFeatureTest.class)
public class ReadFileFeatureTest {
    @Test
    void fileExist(){
        ReadFileFeature readFileFeature = new ReadFileFeature();
        OperationResultMessage<String> readResult = readFileFeature.readToString("src\\main\\data\\recipes.json");
        Assertions.assertEquals(OperationResultStatus.SUCCESS,readResult.getStatus());
        Assertions.assertEquals(StringHelper.EMPTY_STRING,readResult.getMessage());
        Assertions.assertNotEquals(0,readResult.getResult().length());
    }
    @Test
    void fileDoesNotExist(){
        ReadFileFeature readFileFeature = new ReadFileFeature();
        OperationResultMessage<String> readResult = readFileFeature.readToString("src\\main\\data\\abc.json");
        Assertions.assertEquals(OperationResultStatus.ERROR,readResult.getStatus());
        Assertions.assertEquals(readFileHelpers.FILE_NOT_FOUND,readResult.getMessage());

    }
}
