package kiomnd2.icflix.domain.category.season;

import jakarta.persistence.*;
import kiomnd2.icflix.domain.category.Category;
import kiomnd2.icflix.domain.character.Character;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
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

    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;


    @Builder
    public Season(Long numberOfSeason, String author, List<Character> characters, Category category) {
        this.numberOfSeason = numberOfSeason;
        this.author = author;
        this.characterTokenList = characterTokenList;
    }
}
