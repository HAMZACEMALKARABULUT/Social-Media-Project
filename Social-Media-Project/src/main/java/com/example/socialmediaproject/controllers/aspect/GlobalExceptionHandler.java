package com.example.socialmediaproject.controllers.aspect;

import com.example.socialmediaproject.services.exception.CustomException;
import org.apache.coyote.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> handleCustomException(CustomException e){


        return ResponseEntity
                .status((HttpStatus.INTERNAL_SERVER_ERROR))
                .body(e.getMessage());
    }
}
