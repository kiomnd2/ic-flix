package kiomnd2.icflix.domain.category.season;

import jakarta.persistence.*;
import kiomnd2.icflix.domain.category.season.content.Contents;
import kiomnd2.icflix.domain.character.Character;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Season {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numberOfSeason;
    private String author;

    @JoinColumn(name = "character_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Character> characterTokenList;

    @JoinColumn(name = "contents_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Contents> contentsList;

    @Builder
    public Season(Long numberOfSeason, String author, List<Character> characterTokenList, List<Contents> contentsList) {
        this.numberOfSeason = numberOfSeason;
        this.author = author;
        this.characterTokenList = characterTokenList;
        this.contentsList = contentsList;
    }
}
