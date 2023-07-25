package kiomnd2.icflix.domain.member;


import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String name;
    private String pass;
    private String email;

    public MemberInfo toInfo() {
        return MemberInfo.builder()
                .userId(userId)
                .email(email)
                .build();
    }

    public static Member from(MemberCommand.RegisterMember member, PasswordEncoder encoder) {
        return Member.builder()
                .userId(member.getUserId())
                .name(member.getName())
                .pass(encoder.encode(member.getPassword()))
                .email(member.getEmail())
                .build();
    }

    public void update(MemberCommand.UpdateMember member, PasswordEncoder encoder) {
        this.pass = StringUtils.isBlank(member.getPassword()) ? this.pass : encoder.encode(member.getPassword());
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
