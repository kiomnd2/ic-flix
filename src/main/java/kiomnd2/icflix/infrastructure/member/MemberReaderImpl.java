package kiomnd2.icflix.infrastructure.member;

import kiomnd2.icflix.common.response.ErrorCode;
import kiomnd2.icflix.common.response.exception.BaseException;
import kiomnd2.icflix.domain.member.Member;
import kiomnd2.icflix.domain.member.MemberHelper;
import kiomnd2.icflix.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberReaderImpl implements MemberReader {
    private final MemberRepository memberRepository;
    private final MemberHelper helper;
    @Override
    public Member readMember(String userId, String password) {
        return memberRepository.findByUserId(userId)
                .filter(v -> helper.checkMember(v, password))
                .orElseThrow(() -> new BaseException(ErrorCode.COMMON_NOT_FOUND_USER)
        );
    }
}
