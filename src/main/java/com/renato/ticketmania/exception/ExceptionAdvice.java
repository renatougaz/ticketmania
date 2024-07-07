package com.renato.ticketmania.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = TicketNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(TicketNotFoundException ex) {
        return new ResponseEntity<>(ex.message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TagAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleTagAlreadyExistsException(TagAlreadyExistsException ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = TagNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleTTagNotFoundException(TagNotFoundException ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
