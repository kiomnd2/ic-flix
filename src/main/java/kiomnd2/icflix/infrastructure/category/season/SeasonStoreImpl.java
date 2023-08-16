package kiomnd2.icflix.infrastructure.category.season;

import kiomnd2.icflix.domain.category.season.Season;
import kiomnd2.icflix.domain.category.season.SeasonStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SeasonStoreImpl implements SeasonStore {
    private final SeasonRepository seasonRepository;
    @Override
    public Season store(Season season) {
        return seasonRepository.save(season);
    }
}
