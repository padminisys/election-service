package com.padminisys.election.dal.entity;

import lombok.Data;

@Data
public class Result {

    private String id;
    private PollingEvent pollingEvent;
    private Integer castedVote;
    private Integer totalVotes;



}
