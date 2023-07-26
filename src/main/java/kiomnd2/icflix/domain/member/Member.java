package kiomnd2.icflix.domain.member;


import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import kiomnd2.icflix.common.response.ErrorCode;
import kiomnd2.icflix.common.response.exception.BaseException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        if (StringUtils.isEmpty(member.getUserId())) throw new BaseException(ErrorCode.COMMON_SYSTEM_ERROR, "USER_ID");
        if (StringUtils.isEmpty(member.getPassword())) throw new BaseException(ErrorCode.COMMON_SYSTEM_ERROR, "PASSWORD");
        if (StringUtils.isEmpty(member.getName())) throw new BaseException(ErrorCode.COMMON_SYSTEM_ERROR, "NAME");
        if (StringUtils.isEmpty(member.getEmail())) throw new BaseException(ErrorCode.COMMON_SYSTEM_ERROR, "EMAIL");

        if (isValidEmail(member.getEmail())) {
            throw new BaseException(ErrorCode.COMMON_NOT_VALID_EMAIL);
        }

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

    private static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
