package kiomnd2.icflix.common.response.exception;

import kiomnd2.icflix.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private ErrorCode errorCode;

    public BaseException(ErrorCode errorCode, String ... args) {
        super(errorCode.getMessage(args));
        this.errorCode = errorCode;
    }
}
