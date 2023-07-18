package kiomnd2.icflix.interfaces.member;

import kiomnd2.icflix.application.member.MemberFacade;
import kiomnd2.icflix.common.response.CommonResponse;
import kiomnd2.icflix.domain.member.MemberCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApi {
    private final MemberFacade memberFacade;

    @PostMapping("/member")
    public CommonResponse<MemberDto.RegisterResponse> joinMember(MemberDto.RegisterRequest memberDto) {
        String token = memberFacade.joinMember(MemberMapper.INSTANCE.of(memberDto));
        MemberDto.RegisterResponse registerResponse = new MemberDto.RegisterResponse(token);
        return CommonResponse.success(registerResponse);
    }
}
