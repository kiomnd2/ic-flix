package kiomnd2.icflix.infrastructure.member;

import kiomnd2.icflix.common.response.ErrorCode;
import kiomnd2.icflix.common.response.exception.BaseException;
import kiomnd2.icflix.domain.member.Member;
import kiomnd2.icflix.domain.member.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;

    @Override
    public Member store(Member member) {
        Member m = memberRepository.save(member);
        try {
            memberRepository.flush();
        } catch (DataIntegrityViolationException e) {
            // 이미 등록된 사용자
            throw new BaseException(ErrorCode.COMMON_ALREADY_EXIST_USER);
        }
        return m;
    }
}
