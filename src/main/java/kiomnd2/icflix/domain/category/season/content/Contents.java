package kiomnd2.icflix.domain.category.season.content;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
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

    @Builder
    public Contents(Long numberOfContents, String contentsName, String contentsDesc, BigDecimal contentsAmount) {
        this.numberOfContents = numberOfContents;
        this.contentsName = contentsName;
        this.contentsDesc = contentsDesc;
        this.contentsAmount = contentsAmount;
    }
}
