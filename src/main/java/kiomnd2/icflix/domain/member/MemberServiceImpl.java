package kiomnd2.icflix.domain.member;

import kiomnd2.icflix.interfaces.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;
    @Override
    public String joinMember(MemberCommand.RegisterMember member) {
        return memberStore.store(member.toEntity());
    }
}
