package kiomnd2.icflix.domain.member;

public interface MemberService {
    void joinMember(MemberCommand.RegisterMember command);
    MemberInfo loginMember(String userId, String password);
}
