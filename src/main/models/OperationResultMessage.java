package models;

public class OperationResultMessage<T extends Object> {
    private final OperationResultStatus _status;
    private final String _message;
    private final T _result;

    public OperationResultMessage(OperationResultStatus status, String message,T result){
        _message = message;
        _result = result;
        _status = status;
    }
    public OperationResultStatus getStatus(){
        return _status;
    }
    public T getResult(){
        return _result;
    }
    public String getMessage(){
        return _message;
    }

}
