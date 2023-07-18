package kiomnd2.icflix.common.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommonResponse<T> {
    private String code;
    private T body;

    public static <T> CommonResponse<T>  success(T body) {
        return new CommonResponse<>("0000", body);
    }

    public static <T> CommonResponse<String> fail(ErrorCode errorCode) {
        return new CommonResponse<>(errorCode.name(), errorCode.getMessage() );
    }
}
