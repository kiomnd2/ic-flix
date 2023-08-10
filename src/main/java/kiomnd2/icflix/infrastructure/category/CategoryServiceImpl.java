package kiomnd2.icflix.infrastructure.category;

import kiomnd2.icflix.domain.category.CategoryCommand;
import kiomnd2.icflix.domain.character.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryFactory categoryFactory;
    @Override
    public String createCategory(CategoryCommand.RequestCreateCategory command) {
        return categoryFactory.createCategory(command);
    }
}
