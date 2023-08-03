package kiomnd2.icflix.interfaces.character;

import kiomnd2.icflix.domain.character.CharacterCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterMapper {
    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    CharacterCommand.RequestCharacter of(CharacterDto.CreateCharacter character);
}
