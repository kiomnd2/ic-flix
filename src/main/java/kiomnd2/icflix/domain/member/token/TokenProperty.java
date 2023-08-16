package kiomnd2.icflix.domain.member.token;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "jwt")
public class TokenProperty {
    private String secretKey;
    private Long expirationHours;
    private String issuer;
}
