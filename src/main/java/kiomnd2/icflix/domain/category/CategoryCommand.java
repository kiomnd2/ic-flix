package kiomnd2.icflix.domain.category;

import kiomnd2.icflix.domain.category.season.Season;
import kiomnd2.icflix.domain.category.season.content.Contents;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.parameters.P;

import javax.swing.text.AbstractDocument;
import java.math.BigDecimal;
import java.util.List;

public class CategoryCommand {

    @ToString
    @Getter
    @Builder
    public static class RequestCreateCategory {
        private final String categoryId;
        private final String categoryName;
        private final List<RequestCreateSeason> seasonList;

        public Category toEntity() {
            return Category.builder()
                    .categoryId(categoryId)
                    .categoryName(categoryName)
                    .seasonList(seasonList.stream().map(RequestCreateSeason::toEntity).toList())
                    .build();
        }
    }

    @ToString
    @Getter
    @Builder
    public static class RequestCreateSeason {
        private Long numberOfSeason;
        private String author;
        private List<String> characterTokenList;
        private List<RequestCreateContent> contentList;

        public Season toEntity() {
            return Season.builder()
                    .numberOfSeason(numberOfSeason)
                    .author(author)
                    .contentsList(contentList.stream().map(RequestCreateContent::toEntity).toList())
                    .characterTokenList(characterTokenList)
                    .build();
        }
    }

    @ToString
    @Getter
    @Builder
    public static class RequestCreateContent {
        private Long numberOfContents;
        private String contentsName;
        private String contentsDes;
        private BigDecimal contentsAmount;

        public Contents toEntity() {
            return Contents.builder()
                    .numberOfContents(numberOfContents)
                    .contentsName(contentsName)
                    .contentsDesc(contentsDes)
                    .contentsAmount(contentsAmount)
                    .build();
        }
    }
}
