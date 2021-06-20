package com.sda.traianszabi.online_library.error;

import java.time.Instant;

public class ErrorDetails {

    private final Instant timestamp;
    private final String massage;
    private final String details;

    public ErrorDetails(Instant timestamp, String massage, String details) {
        this.timestamp = timestamp;
        this.massage = massage;
        this.details = details;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getMassage() {
        return massage;
    }

    public String getDetails() {
        return details;
    }
}
