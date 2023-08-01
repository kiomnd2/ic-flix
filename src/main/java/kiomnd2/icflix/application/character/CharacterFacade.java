package kiomnd2.icflix.application.character;

import kiomnd2.icflix.domain.character.CharacterCommand;
import kiomnd2.icflix.domain.character.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CharacterFacade {
    private final CharacterService characterService;

    public String createCharacter(CharacterCommand.RequestCharacter command) {
        return "token";
    }
}
