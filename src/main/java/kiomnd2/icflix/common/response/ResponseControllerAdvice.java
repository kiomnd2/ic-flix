package kiomnd2.icflix.common.response;

import com.sun.jdi.event.ExceptionEvent;
import kiomnd2.icflix.common.response.exception.BaseException;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResponseControllerAdvice {

    /**
     * http status 500 and result fail
     * 시스템 예외
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> onException(Exception e) {
        return CommonResponse.fail(ErrorCode.COMMON_SYSTEM_ERROR);
    }

    /**
     * http status 200 and result fail
     * 비지니스 로직 처리 이슈
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BaseException.class)
    public CommonResponse<String> onBaseException(BaseException e) {
        return CommonResponse.fail(e.getErrorCode());
    }
}