package com.padminisys.election.api.mappers;

import com.padminisys.election.api.model.response.HouseResponse;
import com.padminisys.election.dal.entity.House;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HouseMapper {

    @Mapping(target = "countOfMembers", expression = "java(house.getMembers().size())")
    @Mapping(target = "countOfElectionEvent", expression = "java(house.getElectionEvents().size())")
    HouseResponse houseToHouseResponse(House house);

    List<HouseResponse> houseListToHouseResponseList(List<House> houses);
}
