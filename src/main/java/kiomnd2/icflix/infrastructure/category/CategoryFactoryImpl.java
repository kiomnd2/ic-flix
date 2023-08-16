package kiomnd2.icflix.infrastructure.category;

import kiomnd2.icflix.domain.category.Category;
import kiomnd2.icflix.domain.category.CategoryCommand;
import kiomnd2.icflix.domain.category.CategoryFactory;
import kiomnd2.icflix.domain.category.season.Season;
import kiomnd2.icflix.domain.category.season.SeasonStore;
import kiomnd2.icflix.domain.category.season.content.Contents;
import kiomnd2.icflix.domain.category.season.content.ContentsStore;
import kiomnd2.icflix.domain.character.CharacterReader;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class CategoryFactoryImpl implements CategoryFactory {
    private final CategoryRepository categoryRepository;
    private final SeasonStore seasonStore;
    private final ContentsStore contentsStore;
    private final CharacterReader characterReader;

    @Transactional
    @Override
    public Category store(CategoryCommand.RequestCreateCategory command) {
        Category category = categoryRepository.save(command.toEntity());
        for (CategoryCommand.RequestCreateSeason seasons : command.getSeasonList()) {
            Season s = seasons.toEntity(category
                    , seasons.getCharacterTokenList()
                            .stream()
                            .map(characterReader::read)
                            .toList());
            seasonStore.store(s);
            for (CategoryCommand.RequestCreateContent content : seasons.getContentList()) {
                Contents c = content.toEntity(s);
                contentsStore.store(c);
            }
        }
        return category;
    }
}
