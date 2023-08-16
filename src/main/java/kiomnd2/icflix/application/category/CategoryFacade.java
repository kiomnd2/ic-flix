package kiomnd2.icflix.application.category;

import kiomnd2.icflix.domain.category.CategoryCommand;
import kiomnd2.icflix.domain.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryFacade {
    private final CategoryService categoryService;

    public String createCategory(CategoryCommand.RequestCreateCategory command) {
        return categoryService.createCategory(command);
    }
}
