package com.renato.ticketmania.service;

import com.renato.ticketmania.dao.Ticket;
import com.renato.ticketmania.dto.requests.CreateTicketDto;
import com.renato.ticketmania.dto.responses.TicketDto;
import com.renato.ticketmania.dto.responses.TicketListDto;
import com.renato.ticketmania.exception.ErrorMessage;
import com.renato.ticketmania.exception.TagNotFoundException;
import com.renato.ticketmania.exception.TicketNotFoundException;
import com.renato.ticketmania.repository.TagRepository;
import com.renato.ticketmania.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.Collections.emptyList;
import static java.util.UUID.randomUUID;

@Service
@AllArgsConstructor
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TagRepository tagRepository;

    public TicketDto createTicket(CreateTicketDto createTicketDto) {
        var ticket = createTicketDao(createTicketDto);
        return ticketRepository.save(ticket).toDto();
    }

    public TicketDto getTicket(UUID id) {
        return ticketRepository.findById(id)
                .map(Ticket::toDto)
                .orElseThrow(() -> new TicketNotFoundException(new ErrorMessage("Ticket not found")));
    }

    public TicketDto deleteTicket(UUID id) {
        var ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(new ErrorMessage("Ticket not found")));

        ticketRepository.delete(ticket);

        return ticket.toDto();
    }

    public TicketListDto getAllTickets() {
        var tickets = ticketRepository.findAll().stream().map(Ticket::toDto).toList();
        return new TicketListDto(tickets);
    }

    private Ticket createTicketDao(CreateTicketDto createTicketDto) {
        var tags = createTicketDto.tags().stream().map(
                        tagDto -> tagRepository.findById(tagDto.getId())
                                .orElseThrow(() ->
                                        new TagNotFoundException("Tag with ID " + tagDto.getId() + " does not exist")
                                ))
                .toList();
        return new Ticket(
                randomUUID(),
                createTicketDto.title(),
                createTicketDto.description(),
                createTicketDto.stage(),
                createTicketDto.author(),
                createTicketDto.assignee(),
                createTicketDto.important(),
                createTicketDto.pointsType(),
                createTicketDto.pointValue(),
                tags,
                emptyList()
        );
    }
}
