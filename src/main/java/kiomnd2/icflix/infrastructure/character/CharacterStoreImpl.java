package kiomnd2.icflix.infrastructure.character;

import kiomnd2.icflix.domain.character.Character;
import kiomnd2.icflix.domain.character.CharacterStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CharacterStoreImpl implements CharacterStore {
    private final CharacterRepository characterRepository;
    @Override
    public Character store(Character character) {
        return characterRepository.save(character);
    }
}
