package kiomnd2.icflix.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Builder
@RequiredArgsConstructor
@Getter
public class MemberInfo {
    private final String userId;
    private final String email;
}
