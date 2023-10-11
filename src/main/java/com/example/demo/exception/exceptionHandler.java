package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class exceptionHandler {

    @ExceptionHandler(value = {requestException.class})
    public ResponseEntity<Object> handleRequestException(requestException e) {
        HttpStatus badRequest =HttpStatus.BAD_REQUEST;
        //Create exception detais
        exception exception = new exception(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        //Return response entity
        return new ResponseEntity<>(exception, badRequest);
    }
}
