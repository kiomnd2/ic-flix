package kiomnd2.icflix.infrastructure.member;

import kiomnd2.icflix.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
