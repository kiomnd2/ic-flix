package kiomnd2.icflix.interfaces.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MemberDto {

    @Setter
    @Getter
    @ToString
    public static class RegisterRequest {
        @NotNull
        private String userId;
        @NotNull
        private String name;
        private String password;
        @Email
        private String email;
    }

    @Setter
    @Getter
    @ToString
    public static class LoginRequest {
        @NotNull
        private String userId;
        @NotNull
        private String password;
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
