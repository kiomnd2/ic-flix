package kiomnd2.icflix.domain.category;

import jakarta.persistence.*;
import kiomnd2.icflix.common.util.TokenGenerator;
import kiomnd2.icflix.domain.category.season.Season;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Category {
    private final String prefix = "category_";

    @Id @GeneratedValue
    private Long id;
    private String token;
    private String categoryId;
    private String categoryName;

    @JoinColumn(name = "season_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Season> seasonList;

}
