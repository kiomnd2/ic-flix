package kiomnd2.icflix.interfaces.people;

import jakarta.validation.Valid;
import kiomnd2.icflix.application.character.CharacterFacade;
import kiomnd2.icflix.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/character")
public class CharacterApi {
    private final CharacterFacade characterFacade;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public CommonResponse<CharacterDto.ResponseToken> registerCharacter(
            @RequestBody @Valid CharacterDto.CreateCharacter requestDto) {
        String token = characterFacade.createCharacter(CharacterMapper.INSTANCE.of(requestDto));
        return CommonResponse.success(CharacterDto.ResponseToken.builder().token(token).build());
    }
}
