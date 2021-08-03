package com.padminisys.election.api.mappers;

import com.padminisys.election.api.model.response.MemberResponse;
import com.padminisys.election.dal.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MemberMapper {
    MemberResponse memberToMemberResponse(Member member);
    List<MemberResponse> membersToMemberResponses(List<Member> members);
}