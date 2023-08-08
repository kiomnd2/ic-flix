package kiomnd2.icflix.domain.character;

import kiomnd2.icflix.domain.category.CategoryCommand;

public interface CategoryService {

    String createCategory(CategoryCommand.RequestCreateCategory command);
}
