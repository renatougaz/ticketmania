package com.renato.ticketmania.service;

import com.renato.ticketmania.dto.TicketDto;
import com.renato.ticketmania.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renato.ticketmania.dao.Ticket;


import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TicketService {

    @Autowired
    TicketRepository repository;

    public TicketDto createTicket(TicketDto ticketDto) {
        var ticket = ticketDto.toDao();
        return repository.save(ticket).toDto();
    }

    public TicketDto getTicket(UUID id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new).toDto();
    }

    public List<TicketDto> getAllTickets() {
        return repository.findAll().stream().map(Ticket::toDto).toList();
    }
}
