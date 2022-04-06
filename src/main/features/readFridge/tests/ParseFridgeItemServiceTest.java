package features.readFridge.tests;

import features.readFridge.helpers.MessageHelper;
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
        String input = "item,amount,unit,useBy,,,\n" +
                "bread,10,slices,01/04/2022,,,\n" +
                "cheese,10,slices,01/03/2022,,,\n" +
                "butter,250,grams,05/06/2022,,,\n" +
                "peanut butter,250,grams,12/12/2023,,,\n" +
                "mixed salad,500,grams,24/03/2022,,,";
        OperationResultMessage<Fridge> result  = parseFridgeItemService.parse(input);
        Assertions.assertEquals(StringHelper.EMPTY_STRING,result.getMessage());
        Assertions.assertEquals(OperationResultStatus.SUCCESS,result.getStatus());
        Assertions.assertEquals(5, result.getResult().getItems().size());

    }
    @Test
    public void cannotReadFridge(){
        ParseFridgeItemService parseFridgeItemService = new ParseFridgeItemService();
        String input = "////bread,10,slices,1/0\n" +
                "cheese,10,slices,";
        OperationResultMessage<Fridge> result  = parseFridgeItemService.parse(input);
        Assertions.assertEquals(OperationResultStatus.ERROR,result.getStatus());
        Assertions.assertEquals(MessageHelper.invalidFormat(input), result.getMessage());

    }
}
