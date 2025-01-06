package com.renato.ticketmania.dto.responses;

import com.renato.ticketmania.dao.Ticket;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record BoardDto(
        UUID id,
        String title,
        String owner,
        Set<TicketDto> tickets,
        List<String>column
) {
}
