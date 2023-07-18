package kiomnd2.icflix.interfaces.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class MemberDto {

    @Setter
    @Getter
    @ToString
    public static class RegisterRequest {
        private String userId;
        private String password;
        private String email;
    }

    @Setter
    @Getter
    @ToString
    public static class RegisterResponse {
        private String userToken;

        public RegisterResponse(String userToken) {
            this.userToken = userToken;
        }
    }
}
