package kiomnd2.icflix.common.response.exception;

import kiomnd2.icflix.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final ErrorCode errorCode;

    public BaseException(ErrorCode errorCode, Object ... args) {
        super(errorCode.getMessage(args));
        this.errorCode = errorCode;
    }
}
