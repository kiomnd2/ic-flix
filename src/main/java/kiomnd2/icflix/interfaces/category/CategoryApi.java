package kiomnd2.icflix.interfaces.category;

import kiomnd2.icflix.common.response.CommonResponse;
import kiomnd2.icflix.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ap.shaded.freemarker.ext.beans.EnumerationModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryApi {

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public CommonResponse<CategoryDto.ResponseToken> createCategory() {
        return CommonResponse.success(CategoryDto.ResponseToken.builder().token("token").build());
    }
}
