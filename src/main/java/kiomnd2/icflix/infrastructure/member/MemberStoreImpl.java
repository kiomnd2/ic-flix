package kiomnd2.icflix.infrastructure.member;

import kiomnd2.icflix.common.response.ErrorCode;
import kiomnd2.icflix.common.response.exception.BaseException;
import kiomnd2.icflix.domain.member.MemberStore;
import kiomnd2.icflix.domain.member.Member;
import kiomnd2.icflix.domain.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;

    @Override
    public MemberInfo store(Member member) {
        memberRepository.findByUserId(member.getUserId()).ifPresent(v -> {
            throw new BaseException(ErrorCode.COMMON_ALREADY_EXIST_USER);
        });
        return memberRepository.save(member).toInfo();
    }
}
