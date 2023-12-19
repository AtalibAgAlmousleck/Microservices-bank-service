package com.atalibdev.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicationResource extends Exception {

    public DuplicationResource(String message) {
        super(message);
    }
}
