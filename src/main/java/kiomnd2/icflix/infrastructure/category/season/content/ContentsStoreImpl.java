package kiomnd2.icflix.infrastructure.category.season.content;

import kiomnd2.icflix.domain.category.season.content.Contents;
import kiomnd2.icflix.domain.category.season.content.ContentsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ContentsStoreImpl implements ContentsStore {
    private final ContentsRepository contentsRepository;
    @Override
    public Contents store(Contents contents) {
        return contentsRepository.save(contents);
    }
}
