package com.xuegao.xuegaogateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConsoleExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ConsoleExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> handleAccessException(Exception e) {
        log.info("[xue-gao-write-and-use][ConsoleExceptionHandler][handleAccessException][e={}]", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

}
