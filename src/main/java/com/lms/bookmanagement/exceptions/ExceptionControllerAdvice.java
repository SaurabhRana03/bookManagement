package com.lms.bookmanagement.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBNFException(BookNotFoundException exception) {

        ExceptionInfo exInfo = new ExceptionInfo(exception.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());

        return new ResponseEntity<>(exInfo, new HttpHeaders(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Object> handleCNFException(CategoryNotFoundException exception) {

        ExceptionInfo exInfo = new ExceptionInfo(exception.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());

        return new ResponseEntity<>(exInfo, new HttpHeaders(), HttpStatus.NOT_FOUND);


    }

}