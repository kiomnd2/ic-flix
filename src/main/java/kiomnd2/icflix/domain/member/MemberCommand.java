package kiomnd2.icflix.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class MemberCommand {

    @Builder
    @ToString
    @Getter
    public static class RegisterMember {
        private final String userId;
        private final String name;
        private final String password;
        private final String email;


    }

    @Builder
    @ToString
    @Getter
    public static class UpdateMember {
        private final String name;
        private final String password;
        private final String email;
    }
}
