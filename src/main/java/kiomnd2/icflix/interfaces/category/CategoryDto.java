package kiomnd2.icflix.interfaces.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

public class CategoryDto {

    @ToString
    @Setter
    @Getter
    public static class RequestCreateCategory {
        private String categoryId;
        private String categoryName;
        private List<RequestCreateSeason> seasonList;
    }

    @ToString
    @Setter
    @Getter
    public static class RequestCreateSeason {
        private Long numberOfSeason;
        private String author;
        private List<String> characterTokenList;
        private List<RequestCreateContent> contentList;
    }

    @ToString
    @Setter
    @Getter
    public static class RequestCreateContent {
        private Long numberOfContents;
        private String contentName;
        private String contentsDesc;
        private BigDecimal contentsAmount;
    }

    @ToString
    @Builder
    public static class ResponseToken {
        private String token;
    }
}
