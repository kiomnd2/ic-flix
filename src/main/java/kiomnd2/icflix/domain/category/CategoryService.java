package kiomnd2.icflix.domain.category;

public interface CategoryService {

    String createCategory(CategoryCommand.RequestCreateCategory command);
}
