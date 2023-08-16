package kiomnd2.icflix.domain.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryFactory categoryFactory;
    @Override
    public String createCategory(CategoryCommand.RequestCreateCategory command) {
        return categoryFactory.store(command).getCategoryId();
    }
}
