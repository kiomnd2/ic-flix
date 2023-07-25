package kiomnd2.icflix.domain.member.token;

public interface TokenProvider {
    String createToken(String userSpecification);

    String validToken(String s);
}
