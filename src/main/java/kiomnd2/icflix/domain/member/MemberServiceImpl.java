package kiomnd2.icflix.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final MemberCreateHelper memberCreateHelper;
    @Override
    public MemberInfo joinMember(MemberCommand.RegisterMember member) {
        return memberStore.store(memberCreateHelper.createMember(member));
    }
}
