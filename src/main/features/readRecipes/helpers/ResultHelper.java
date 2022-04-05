package features.readRecipes.helpers;

import features.readRecipes.models.Recipes;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;

public class ResultHelper {
    public static OperationResultMessage<Recipes> successResult(Recipes result){
        return new OperationResultMessage<>(OperationResultStatus.SUCCESS, StringHelper.EMPTY_STRING,result);
    }
    public static OperationResultMessage<Recipes> errorResult(String message){
        return new OperationResultMessage<>(OperationResultStatus.ERROR,message,null);
    }
}
