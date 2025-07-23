package com.example.simple_crm;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(CustomerNotFoundException.class)
    // public ResponseEntity<ErrorResponse>
    // handleCustomerNotFoundException(CustomerNotFoundException e) {
    // ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),
    // LocalDateTime.now());
    // return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    // }

    // @ExceptionHandler(InteractionNotFoundException.class)
    // public ResponseEntity<ErrorResponse>
    // handleInteractionNotFoundException(InteractionNotFoundException e) {
    // ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),
    // LocalDateTime.now());
    // return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    // }

    // Handle both exceptions
    @ExceptionHandler({ CustomerNotFoundException.class, InteractionNotFoundException.class })
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Validation Exception Handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException (MethodArgumentNotValidException e) {
        // Get a list of all validation errors from the exception object
        List<ObjectError> validationErrors = e.getBindingResult().getAllErrors();

        // Create a StringBuilder to store all error messages
        StringBuilder sb = new StringBuilder();

        // Loop through all the errors and append error messages to the StringBuilder
        for (ObjectError error: validationErrors) {
            sb.append(error.getDefaultMessage() + ". ");
        }

        ErrorResponse errorResponse = new ErrorResponse(sb.toString(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse("Something went wrong. Please contact the administrator.",
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
