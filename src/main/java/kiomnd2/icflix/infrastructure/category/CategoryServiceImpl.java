package kiomnd2.icflix.infrastructure.category;

import kiomnd2.icflix.domain.category.CategoryCommand;
import kiomnd2.icflix.domain.category.CategoryStore;
import kiomnd2.icflix.domain.character.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryStore categoryStore;
    @Override
    public String createCategory(CategoryCommand.RequestCreateCategory command) {
        return categoryStore.store(command.toEntity()).getCategoryId();
    }
}
