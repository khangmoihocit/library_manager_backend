package khangmoihocit.library_manager.exception;

import khangmoihocit.library_manager.enums.ErrorCode;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException{
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
