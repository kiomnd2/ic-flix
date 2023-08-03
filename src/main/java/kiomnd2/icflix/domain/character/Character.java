package kiomnd2.icflix.domain.character;

import jakarta.persistence.*;
import kiomnd2.icflix.common.util.TokenGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Character {
    private final String prefix = "character_";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String token;
    private String birthDate;
    private String gender;
    private Long height;
    private LocalDateTime createAt;

    @Builder
    public Character(String name, String birthDate, String gender, Long height) {
        this.name = name;
        this.token = TokenGenerator.randomCharacterWithPrefix(prefix);
        this.birthDate = birthDate;
        this.gender = gender;
        this.height = height;
    }
}
