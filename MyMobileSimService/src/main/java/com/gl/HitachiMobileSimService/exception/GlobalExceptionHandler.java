package com.gl.HitachiMobileSimService.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            if (fieldName.equals("serviceNumberString")) {
                fieldName = "serviceNumber";
            } else if (fieldName.equals("simNumberString")) {
                fieldName = "simNumber";
            }
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(InvalidSimServiceNumber.class)
    public ResponseEntity<String> handleInvalidSimService(InvalidSimServiceNumber ex){

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}







