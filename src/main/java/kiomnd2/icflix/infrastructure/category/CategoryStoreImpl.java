package kiomnd2.icflix.infrastructure.category;

import kiomnd2.icflix.domain.category.Category;
import kiomnd2.icflix.domain.category.CategoryStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryStoreImpl implements CategoryStore {
    private final CategoryRepository categoryRepository;
    @Override
    public Category store(Category category) {
        return categoryRepository.save(category);
    }
}
