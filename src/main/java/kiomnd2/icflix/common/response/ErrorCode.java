package kiomnd2.icflix.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요"),
    COMMON_ALREADY_EXIST_USER("이미 등록된 사용자 아이디 입니다."),
    COMMON_NOT_FOUND_USER("이미 등록된 사용자 아이디 입니다."),
    COMMON_NOT_VALID_EMAIL("이미 등록된 사용자 아이디 입니다."),
    COMMON_REQUIRED_VALUE("%s 는 필수 값입니다");

    private final String message;

    public String getMessage(Object ... arg) {
        return String.format(message, arg);
    }
}
