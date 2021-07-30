package com.padminisys.election.api.model.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HouseResponse {

    private Long id;
    private String name;
    private Integer countOfMembers;
    private Integer countOfElectionEvent;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;
}