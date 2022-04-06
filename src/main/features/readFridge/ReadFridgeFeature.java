package features.readFridge;

import features.readFile.ReadFileFeature;
import features.readFridge.helpers.ReadFridgeResultHelper;
import models.fridge.Fridge;
import features.readFridge.services.ParseFridgeItemService;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;
import org.springframework.stereotype.Service;

@Service
public class ReadFridgeFeature {
    private final ParseFridgeItemService parseFridgeItemService;
    private final ReadFileFeature readFileFeature;
    public ReadFridgeFeature(ParseFridgeItemService parseFridgeItemService,ReadFileFeature readFileFeature){
        this.parseFridgeItemService = parseFridgeItemService;
        this.readFileFeature = readFileFeature;
    }
    public OperationResultMessage<Fridge> getFridgeItems(){
            OperationResultMessage<String> readFridgeItemList = ReadFridgeItemList();
            if (IsReadingFridgeItemListUnsuccessful(readFridgeItemList)){
                return ReadFridgeResultHelper.errorResult(readFridgeItemList.getMessage());
            }
            return ParseRecipeList(readFridgeItemList.getResult());

    }

    private OperationResultMessage<Fridge> ParseRecipeList(String input) {
        return parseFridgeItemService.parse(input);
    }

    private boolean IsReadingFridgeItemListUnsuccessful(OperationResultMessage<String> readFridgeItemList) {
        return readFridgeItemList.getStatus() != OperationResultStatus.SUCCESS;
    }

    private OperationResultMessage<String> ReadFridgeItemList() {
        return readFileFeature.readToString(StringHelper.FRIDGE_ITEMLIST_FILE_PATH);
    }

}
