package kiomnd2.icflix.application.character;

import kiomnd2.icflix.domain.character.CharacterCommand;
import kiomnd2.icflix.domain.character.CharacterStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CharacterFacade {
    private final CharacterStore store;

    public String createCharacter(CharacterCommand.RequestCharacter command) {
        return store.store(command.toEntity()).getToken();
    }
}
