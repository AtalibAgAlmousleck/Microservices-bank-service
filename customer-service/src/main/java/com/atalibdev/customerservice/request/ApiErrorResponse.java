package com.atalibdev.customerservice.request;

import java.time.LocalDateTime;
public record ApiErrorResponse(
        String path,
        String message,
        int statusCode,
        LocalDateTime localDateTime) {
}
