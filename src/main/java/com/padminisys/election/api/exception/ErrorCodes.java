package com.padminisys.election.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCodes {
    DATABASE_OBJECT_NOT_FOUND(1);
    private final int code;
}