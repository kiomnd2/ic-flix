package kiomnd2.icflix.interfaces.member;

import kiomnd2.icflix.application.member.MemberFacade;
import kiomnd2.icflix.common.response.CommonResponse;
import kiomnd2.icflix.domain.member.MemberCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
public class MemberApi {
    private final MemberFacade memberFacade;

    @PostMapping(value = "/sign-in", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse<MemberDto.RegisterResponse> joinMember(@RequestBody MemberDto.RegisterRequest memberDto) {
        String token = memberFacade.joinMember(MemberMapper.INSTANCE.of(memberDto));
        MemberDto.RegisterResponse registerResponse = new MemberDto.RegisterResponse(token);
        return CommonResponse.success(registerResponse);
    }
}
