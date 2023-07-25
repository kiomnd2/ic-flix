package kiomnd2.icflix.domain.member;

import lombok.Getter;
import lombok.ToString;

public class MemberQuery {

    @ToString
    @Getter
    public static class InquireMember {
        private String userId;
        private String password;
    }
}
