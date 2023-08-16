package kiomnd2.icflix.infrastructure.category;

import kiomnd2.icflix.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
