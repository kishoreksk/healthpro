package com.healthpro.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(final String message) { super(message); }

    public RecordNotFoundException(final String message, final Throwable t) { super(message, t); }
}
