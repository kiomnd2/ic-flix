package kiomnd2.icflix.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberCreateHelper {
    private final PasswordEncoder encoder;

    public Member createMember(MemberCommand.RegisterMember member) {
        return Member.from(member, encoder);
    }
}
