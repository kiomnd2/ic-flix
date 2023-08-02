package kiomnd2.icflix.domain.character;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class CharacterCommand {

    @Builder
    @ToString
    @Getter
    public static class RequestCharacter {
        private final String name;
        private final String birthDate;
        private final String gender;
        private final Long height;

        public Character toEntity() {
            return Character.builder()
                    .name(name)
                    .birthDate(birthDate)
                    .gender(gender)
                    .height(height)
                    .build();
        }
    }
}
