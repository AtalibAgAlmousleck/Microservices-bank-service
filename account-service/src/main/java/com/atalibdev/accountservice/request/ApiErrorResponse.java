package com.atalibdev.accountservice.request;

import java.time.LocalDateTime;

public record ApiErrorResponse(
        String path,
        String message,
        int statusCode,
        LocalDateTime localDateTime) {
}
