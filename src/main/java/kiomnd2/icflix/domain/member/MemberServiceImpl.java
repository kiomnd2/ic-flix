package kiomnd2.icflix.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;
    @Override
    public MemberInfo joinMember(MemberCommand.RegisterMember member) {
        return memberStore.store(member.toEntity());
    }
}
