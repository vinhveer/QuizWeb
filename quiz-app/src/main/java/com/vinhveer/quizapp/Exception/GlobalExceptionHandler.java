package com.vinhveer.quizapp.Exception;

import com.vinhveer.quizapp.Payload.Response.BodyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BodyResponse<String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        BodyResponse<String> response = new BodyResponse<>("error", ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BodyResponse<Object>> handleInvalidRequestException(InvalidRequestException ex) {
        BodyResponse<Object> response = new BodyResponse<>("fail", ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BodyResponse<String>> handleGeneralException() {
        BodyResponse<String> response = new BodyResponse<>("error", "An unexpected error occurred", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
