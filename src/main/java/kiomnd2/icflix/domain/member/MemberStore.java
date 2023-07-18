package kiomnd2.icflix.domain.member;

import kiomnd2.icflix.interfaces.member.Member;
import kiomnd2.icflix.interfaces.member.MemberInfo;

public interface MemberStore {

    MemberInfo store(Member member);
}
