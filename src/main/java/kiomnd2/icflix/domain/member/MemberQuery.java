package kiomnd2.icflix.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class MemberQuery {

    @Builder
    @ToString
    @Getter
    public static class InquireMember {
        private String userId;
        private String password;
    }
}
