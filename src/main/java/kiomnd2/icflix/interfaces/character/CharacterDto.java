package kiomnd2.icflix.interfaces.character;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CharacterDto {

    @ToString
    @Getter
    @Setter
    public static class CreateCharacter {
        private String name; // 이름
        private String birthDate; // 생년월일
        private String gender; // 성별
        private Long height; // 키
    }

    @ToString
    @Builder
    public static class ResponseToken {
        private String token;
    }
}
