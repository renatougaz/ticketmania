package com.renato.ticketmania.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = TicketNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(TicketNotFoundException ex) {
        return new ResponseEntity<>(ex.message, HttpStatus.NOT_FOUND);
    }
}
