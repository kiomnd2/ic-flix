package kiomnd2.icflix.interfaces.member;

import kiomnd2.icflix.domain.member.MemberCommand;
import kiomnd2.icflix.domain.member.MemberQuery;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberCommand.RegisterMember of(MemberDto.RegisterRequest register);
    MemberQuery.InquireMember of(MemberDto.LoginRequest request);
}
