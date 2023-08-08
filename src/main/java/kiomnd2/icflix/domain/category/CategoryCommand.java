package kiomnd2.icflix.domain.category;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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
    }

    @ToString
    @Getter
    @Builder
    public static class RequestCreateSeason {
        private Long numberOfSeason;
        private String author;
        private List<String> characterTokenList;
        private List<RequestCreateContent> contentList;
    }

    @ToString
    @Getter
    @Builder
    public static class RequestCreateContent {
        private Long numberOfContents;
        private String contentsName;
        private String contentsDes;
        private BigDecimal contentsAmount;
    }
}
