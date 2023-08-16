package kiomnd2.icflix.infrastructure.category;

import kiomnd2.icflix.common.response.ErrorCode;
import kiomnd2.icflix.common.response.exception.BaseException;
import kiomnd2.icflix.domain.category.Category;
import kiomnd2.icflix.domain.category.CategoryReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryReaderImpl implements CategoryReader {
    private final CategoryRepository categoryRepository;
    @Override
    public Category read(String token) {
        return categoryRepository.findByToken(token).orElseThrow(
                () -> new BaseException(ErrorCode.COMMON_NOT_FOUND_CATEGORY)
        );
    }
}
