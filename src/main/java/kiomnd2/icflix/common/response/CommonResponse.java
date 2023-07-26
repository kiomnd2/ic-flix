package kiomnd2.icflix.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String code;
    private T body;
    private String message;

    public static <T> CommonResponse<T>  success(T body) {
        return new CommonResponse<>("0000", body, null);
    }

    public static <T> CommonResponse<String> fail(ErrorCode errorCode) {
        return new CommonResponse<>(errorCode.name(), null, errorCode.getMessage());
    }

    public static <T> CommonResponse<String> fail(ErrorCode errorCode, Object ... args) {
        return new CommonResponse<>(errorCode.name(), null, errorCode.getMessage(args));
    }
}
