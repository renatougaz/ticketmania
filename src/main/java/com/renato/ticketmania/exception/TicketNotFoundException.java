package com.renato.ticketmania.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketNotFoundException extends RuntimeException {
    ErrorMessage message;
}
