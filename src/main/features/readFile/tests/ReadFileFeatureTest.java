import features.readFile.ReadFileFeature;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import features.readFile.helpers.readFileHelpers;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest(classes=ReadFileFeatureTest.class)
public class ReadFileFeatureTest {
    @Test
    void fileExist(){
        ReadFileFeature readFileFeature = new ReadFileFeature();
        OperationResultMessage<File> readResult = readFileFeature.read("D:\\SideProjects\\RecipeApplication\\src\\main\\data\\recipe.json");
        Assertions.assertEquals(OperationResultStatus.SUCCESS,readResult.getStatus());
        Assertions.assertEquals("",readResult.getMessage());

    }
    @Test
    void fileDoesNotExist(){
        ReadFileFeature readFileFeature = new ReadFileFeature();
        OperationResultMessage<File> readResult = readFileFeature.read("D:\\SideProjects\\RecipeApplication\\src\\main\\data\\abc.json");
        Assertions.assertEquals(OperationResultStatus.ERROR,readResult.getStatus());
        Assertions.assertEquals(readFileHelpers.FILE_NOT_FOUND,readResult.getMessage());

    }
}
