package kiomnd2.icflix.interfaces.category;

import kiomnd2.icflix.domain.category.CategoryCommand;
import org.mapstruct.factory.Mappers;

public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryCommand.RequestCreateCategory of(CategoryDto.RequestCreateCategory categoryDto);
}
