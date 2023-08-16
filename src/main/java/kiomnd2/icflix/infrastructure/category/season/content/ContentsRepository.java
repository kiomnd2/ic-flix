package kiomnd2.icflix.infrastructure.category.season.content;

import kiomnd2.icflix.domain.category.season.content.Contents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentsRepository extends JpaRepository<Contents, Long> {
}
