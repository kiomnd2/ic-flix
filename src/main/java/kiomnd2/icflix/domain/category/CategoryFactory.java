package kiomnd2.icflix.domain.category;

public interface CategoryFactory {
    Category store(CategoryCommand.RequestCreateCategory command);
}
