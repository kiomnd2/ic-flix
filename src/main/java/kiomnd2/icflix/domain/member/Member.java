package kiomnd2.icflix.domain.member;


import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, scale = 20, unique = true)
    private String userId;
    private String name;

    @Column(nullable = false)
    private String pass;
    private String email;
    private MemberType memberType;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public static Member from(MemberCommand.RegisterMember member, PasswordEncoder encoder) {
        return Member.builder()
                .userId(member.getUserId())
                .name(member.getName())
                .pass(encoder.encode(member.getPassword()))
                .email(member.getEmail())
                .memberType(MemberType.MEMBER)
                .build();
    }

    public void update(MemberCommand.UpdateMember member, PasswordEncoder encoder) {
        this.pass = StringUtils.isBlank(member.getPassword()) ? this.pass : encoder.encode(member.getPassword());
        this.name = member.getName();
        this.email = member.getEmail();
    }

    public enum MemberType {
        MEMBER, ADMIN
    }
}
