package com.dariojolo.zaratest.app.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Not Found Exception (404)";

    public ResourceNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
