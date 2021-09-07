package com.booking.error;

import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
public class ErrorResponse {

    private int status;
    private String message;
    private long timestamp;

    public ErrorResponse() {

    }

    public ErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
