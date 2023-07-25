package kiomnd2.icflix.domain.member;

public interface MemberReader {
    Member readMember(String userId, String password);
}
