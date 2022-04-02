package features.readFile;

import models.OperationResultMessage;
import models.OperationResultStatus;

public class ReadFileFeature{
    public OperationResultMessage<Object> read(String fileLocation){
        return new OperationResultMessage<Object>(OperationResultStatus.ERROR,"",null);
    }
}