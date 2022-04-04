package features.readFile;

import features.readFile.helpers.readFileHelpers;
import models.OperationResultMessage;
import models.OperationResultStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileFeature{
    public OperationResultMessage<String> readToString(String fileLocation){
        try{
            Path filePath = Paths.get(fileLocation);
            String result = Files.readString(filePath);
            return successResponse(result);
        }
        catch(Exception e){
            if (e instanceof IOException){
                return errorResponse(readFileHelpers.FILE_NOT_FOUND);
            }
            return errorResponse(e.getMessage());
        }

    }
    private OperationResultMessage<String> successResponse(String fileString){
        return new OperationResultMessage<String>(OperationResultStatus.SUCCESS,readFileHelpers.EMPTY_STRING,fileString);
    }
    private OperationResultMessage<String> errorResponse(String message){
        return new OperationResultMessage<String>(OperationResultStatus.ERROR,message,readFileHelpers.EMPTY_STRING);
    }
}