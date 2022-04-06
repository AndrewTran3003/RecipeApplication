import features.readFile.ReadFileFeature;
import features.readFridge.ReadFridgeFeature;
import models.fridge.Fridge;
import features.readFridge.services.ParseFridgeItemService;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ReadFridgeFeatureTest.class)
public class ReadFridgeFeatureTest {
    @Test
    public void canReadFridgeItemList(){
        ParseFridgeItemService service = new ParseFridgeItemService();
        ReadFileFeature readFileFeature = new ReadFileFeature();
        ReadFridgeFeature feature = new ReadFridgeFeature(service,readFileFeature);
        OperationResultMessage<Fridge> fridgeItemListResult = feature.getFridgeItems();
        Assertions.assertEquals(StringHelper.EMPTY_STRING, fridgeItemListResult.getMessage());
        Assertions.assertEquals(OperationResultStatus.SUCCESS, fridgeItemListResult.getStatus());
        Assertions.assertEquals(5, fridgeItemListResult.getResult().getItems().size());
    }
}
