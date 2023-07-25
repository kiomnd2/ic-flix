package kiomnd2.icflix.infrastructure.member;

import kiomnd2.icflix.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByUserId(String userId);
}
