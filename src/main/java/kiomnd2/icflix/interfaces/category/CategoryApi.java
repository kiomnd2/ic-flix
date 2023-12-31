package kiomnd2.icflix.interfaces.category;

import kiomnd2.icflix.application.category.CategoryFacade;
import kiomnd2.icflix.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryApi {
    private final CategoryFacade categoryFacade;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public CommonResponse<CategoryDto.ResponseToken> createCategory(CategoryDto.RequestCreateCategory createDto) {
        String token = categoryFacade.createCategory(CategoryMapper.INSTANCE.of(createDto));

        return CommonResponse.success(CategoryDto.ResponseToken.builder().token(token).build());
    }
}
