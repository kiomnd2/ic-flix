package kiomnd2.icflix.infrastructure.category.season;

import kiomnd2.icflix.domain.category.season.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
