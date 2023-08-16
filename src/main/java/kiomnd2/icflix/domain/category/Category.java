package kiomnd2.icflix.domain.category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import kiomnd2.icflix.common.util.TokenGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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
    private String registerName;



    @Builder
    public Category(String categoryId, String categoryName) {
        this.token = TokenGenerator.randomCharacterWithPrefix(prefix);
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
