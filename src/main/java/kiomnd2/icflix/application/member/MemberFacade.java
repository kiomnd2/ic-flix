package kiomnd2.icflix.application.member;

import kiomnd2.icflix.domain.member.MemberCommand;
import kiomnd2.icflix.domain.member.MemberInfo;
import kiomnd2.icflix.domain.member.MemberQuery;
import kiomnd2.icflix.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberFacade {
    private final MemberService memberService;
    public void joinMember(MemberCommand.RegisterMember memberCommand) {
        memberService.joinMember(memberCommand);
        // 토큰 리턴
    }

    public MemberInfo loginMember(MemberQuery.InquireMember query) {
        return memberService.loginMember(query.getUserId(), query.getPassword());
    }
}
