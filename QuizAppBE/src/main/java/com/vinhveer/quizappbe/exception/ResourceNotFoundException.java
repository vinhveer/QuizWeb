package com.vinhveer.quizappbe.exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s not found with %s : '%s'", resource, field, value));
    }
}
