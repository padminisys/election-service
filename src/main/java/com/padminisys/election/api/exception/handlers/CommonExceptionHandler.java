package com.padminisys.election.api.exception.handlers;

import com.padminisys.election.api.exception.ErrorCodes;
import com.padminisys.election.api.exception.ObjectNotFoundException;
import com.padminisys.election.api.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleNoObject(ObjectNotFoundException objectNotFoundException, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ErrorCodes.DATABASE_OBJECT_NOT_FOUND.getCode());
        errorResponse.setMessage(ErrorCodes.DATABASE_OBJECT_NOT_FOUND.name());
        errorResponse.setSystemMessage(objectNotFoundException.getLocalizedMessage());
        errorResponse.setUserId(webRequest.getUserPrincipal().getName());
        errorResponse.setSessionId(webRequest.getSessionId());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}