package features.readFridge.helpers;

import models.fridge.Fridge;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;

public class ReadFridgeResultHelper {
    public static OperationResultMessage<Fridge> successResult(Fridge result){
        return new OperationResultMessage<>(OperationResultStatus.SUCCESS, StringHelper.EMPTY_STRING,result);
    }
    public static OperationResultMessage<Fridge> errorResult(String message){
        return new OperationResultMessage<>(OperationResultStatus.ERROR,message,null);
    }
}
