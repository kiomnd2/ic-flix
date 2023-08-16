package kiomnd2.icflix.infrastructure.character;

import kiomnd2.icflix.common.response.ErrorCode;
import kiomnd2.icflix.common.response.exception.BaseException;
import kiomnd2.icflix.domain.character.Character;
import kiomnd2.icflix.domain.character.CharacterReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CharacterReaderImpl implements CharacterReader {
    private final CharacterRepository repository;
    @Override
    public Character read(String token) {
        return repository.findByToken(token).orElseThrow(() -> new BaseException(ErrorCode.COMMON_NOT_FOUND_CHARACTER));
    }
}
