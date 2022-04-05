package features.readFridge.tests;

import features.readFridge.models.Fridge;
import features.readFridge.services.ParseFridgeItemService;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest (classes = ParseFridgeItemServiceTest.class)
public class ParseFridgeItemServiceTest {
    @Test
    public void canReadFridge(){
        ParseFridgeItemService parseFridgeItemService = new ParseFridgeItemService();
        String test = "bread,10,slices,1/04/2022 ,,,\n" +
                "cheese,10,slices,1/03/2022 ,,,\n" +
                "butter,250,grams,5/06/2022 ,,,\n" +
                "peanut butter,250,grams,12/12/2023 ,,,\n" +
                "mixed salad,500,grams,24/03/2022,,,";
        OperationResultMessage<Fridge> result  = parseFridgeItemService.parse(test);
        Assertions.assertEquals(OperationResultStatus.SUCCESS,result.getStatus());
        Assertions.assertEquals(StringHelper.EMPTY_STRING,result.getMessage());
        Assertions.assertNotEquals(0, result.getResult().getItems().size());

    }
    @Test
    public void cannotReadFridge(){
        ParseFridgeItemService parseFridgeItemService = new ParseFridgeItemService();
        String test = "////bread,10,slices,1/0\n" +
                "cheese,10,slices,";
        OperationResultMessage<Fridge> result  = parseFridgeItemService.parse(test);
        Assertions.assertEquals(OperationResultStatus.ERROR,result.getStatus());
        Assertions.assertNotEquals(StringHelper.EMPTY_STRING, result.getMessage());

    }
}
