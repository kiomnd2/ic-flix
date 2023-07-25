package kiomnd2.icflix.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final MemberHelper memberCreateHelper;
    @Override
    public MemberInfo joinMember(MemberCommand.RegisterMember member) {
        return memberStore.store(memberCreateHelper.createMember(member)).toInfo();
    }

    @Override
    public MemberInfo loginMember(MemberQuery.InquireMember query) {
        Member member = memberReader.readMember(query.getUserId(), query.getPassword());
        return member.toInfo();
    }
}
