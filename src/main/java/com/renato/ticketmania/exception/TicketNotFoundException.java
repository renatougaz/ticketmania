package com.renato.ticketmania.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(String message) {
        super(message);
    }
}
