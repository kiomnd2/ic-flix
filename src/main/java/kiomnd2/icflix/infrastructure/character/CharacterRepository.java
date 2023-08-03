package kiomnd2.icflix.infrastructure.character;

import kiomnd2.icflix.domain.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Optional<Character> findByToken(String token);
}
