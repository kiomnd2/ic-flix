package kiomnd2.icflix.domain.category.season.content;

import jakarta.persistence.*;
import kiomnd2.icflix.domain.category.season.Season;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contents {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numberOfContents;
    private String contentsName;
    private String contentsDesc;
    private BigDecimal contentsAmount;

    @JoinColumn(name = "season_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Season season;

    @Builder
    public Contents(Long numberOfContents, String contentsName, String contentsDesc, BigDecimal contentsAmount, Season season) {
        this.numberOfContents = numberOfContents;
        this.contentsName = contentsName;
        this.contentsDesc = contentsDesc;
        this.contentsAmount = contentsAmount;
        this.season = season;
    }
}
