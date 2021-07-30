package com.padminisys.election.api.model.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private Integer code;
    private String systemMessage;
    private String userId;
    private String sessionId;
}