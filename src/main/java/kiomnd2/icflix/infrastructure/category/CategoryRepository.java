package kiomnd2.icflix.infrastructure.category;

import kiomnd2.icflix.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByToken(String token);
}
