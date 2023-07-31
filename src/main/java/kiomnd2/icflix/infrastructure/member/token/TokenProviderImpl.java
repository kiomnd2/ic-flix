package kiomnd2.icflix.infrastructure.member.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kiomnd2.icflix.domain.member.token.TokenProperty;
import kiomnd2.icflix.domain.member.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Component
public class TokenProviderImpl implements TokenProvider {
    private final TokenProperty tokenProperty;
    @Override
    public String createToken(String userSpecification) {
        return Jwts.builder()
                .signWith(new SecretKeySpec(tokenProperty.getSecretKey().getBytes(),
                        SignatureAlgorithm.HS512.getJcaName()))
                .setIssuer(tokenProperty.getIssuer())
                .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
                .setSubject(userSpecification)
                .setExpiration(Date.from(Instant.now().plus(tokenProperty.getExpirationHours(), ChronoUnit.HOURS)))    // JWT 토큰 만료 시간
                .compact();
    }

    @Override
    public String validToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(tokenProperty.getSecretKey().getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
