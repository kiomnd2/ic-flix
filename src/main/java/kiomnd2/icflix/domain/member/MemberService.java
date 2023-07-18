package kiomnd2.icflix.domain.member;

public interface MemberService {
    MemberInfo joinMember(MemberCommand.RegisterMember member);
}
