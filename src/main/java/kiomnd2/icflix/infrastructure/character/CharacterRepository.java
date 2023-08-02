package kiomnd2.icflix.infrastructure.character;

import kiomnd2.icflix.domain.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
