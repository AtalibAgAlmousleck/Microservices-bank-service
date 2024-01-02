package com.atalibdev.accountservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicationResourceException extends Exception {
    public DuplicationResourceException(String message) {
        super(message);
    }
}
