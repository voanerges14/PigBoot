package com.little_pig_bot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleBadRequestException(RuntimeException e, HttpServletRequest request) {
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

}

