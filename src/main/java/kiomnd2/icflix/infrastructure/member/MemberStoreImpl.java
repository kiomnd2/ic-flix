package kiomnd2.icflix.infrastructure.member;

import kiomnd2.icflix.domain.member.MemberStore;
import kiomnd2.icflix.interfaces.member.Member;
import kiomnd2.icflix.interfaces.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;

    @Override
    public MemberInfo store(Member member) {
        return memberRepository.save(member).toInfo();
    }
}
