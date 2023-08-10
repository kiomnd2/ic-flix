package kiomnd2.icflix.infrastructure.category;

import kiomnd2.icflix.domain.category.CategoryCommand;

public interface CategoryFactory {
    String createCategory(CategoryCommand.RequestCreateCategory command);
}
