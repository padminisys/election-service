package com.padminisys.election.api.model.response;

import com.padminisys.election.dal.entity.constant.ApprovalStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberResponse {

    private Long id;
    private String username;
    private String name;
    private String mobile;
    private String email;
    private String unit;
    private String address;
    private String aadhar;
    private String pan;
    private String photoKey;
    private ApprovalStatus status;
    private String userId;
    private HouseResponse house;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;
}