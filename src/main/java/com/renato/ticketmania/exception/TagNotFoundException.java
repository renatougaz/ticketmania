package com.renato.ticketmania.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(String message) {
        super(message);
    }
}
