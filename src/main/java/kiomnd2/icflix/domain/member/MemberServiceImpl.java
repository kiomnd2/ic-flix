package kiomnd2.icflix.domain.member;

import kiomnd2.icflix.domain.member.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final MemberHelper memberHelper;
    private final TokenProvider tokenProvider;

    @Override
    public void joinMember(MemberCommand.RegisterMember member) {
        memberStore.store(memberHelper.createMember(member));
    }

    @Override
    public MemberInfo loginMember(String userId, String password) {
        Member member = memberReader.readMember(userId, password);
        return MemberInfo.builder()
                .name(member.getName())
                .email(member.getEmail())
                .memberType(member.getMemberType())
                .token(tokenProvider.createToken(String.format("%s:%s", member.getId(), member.getMemberType().name())))
                .build();
    }
}
