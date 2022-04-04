package features.readFile;

import models.OperationResultMessage;
import models.OperationResultStatus;
import features.readFile.helpers.readFileHelpers;
import java.io.File;

public class ReadFileFeature{
    public OperationResultMessage<File> read(String fileLocation){
        try{
            File result = new File(fileLocation);
            if(!result.exists()){
                return errorResponse(readFileHelpers.FILE_NOT_FOUND);
            }
            return successResponse(result);
        }
        catch(Exception e){
            return errorResponse(e.getMessage());
        }

    }
    private OperationResultMessage<File> successResponse(File file){
        return new OperationResultMessage<File>(OperationResultStatus.SUCCESS,"",file);
    }
    private OperationResultMessage<File> errorResponse(String message){
        return new OperationResultMessage<File>(OperationResultStatus.ERROR,message,null);
    }
}