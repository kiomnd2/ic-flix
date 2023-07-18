package kiomnd2.icflix.domain.member;

import kiomnd2.icflix.interfaces.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class MemberCommand {

    @Builder
    @ToString
    @Getter
    public static class RegisterMember {
        private final String userId;
        private final String password;
        private final String email;

        public Member toEntity() {
            return Member.builder()
                    .userId(userId)
                    .password(password)
                    .email(email)
                    .build();
        }
    }
}
