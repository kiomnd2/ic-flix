package kiomnd2.icflix.interfaces.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class CategoryDto {

    @ToString
    @Setter
    @Getter
    public static class RequestCreateCategory {
        private String categoryId;
        private String categoryName;
    }

    @ToString
    @Setter
    @Getter
    public static class RequestCreateMovieSeason {
        private String movieName;
        private String author;
    }

    @ToString
    @Builder
    public static class ResponseToken {
        private String token;
    }
}
