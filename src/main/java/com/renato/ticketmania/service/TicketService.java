package com.renato.ticketmania.service;

import com.renato.ticketmania.dao.Tag;
import com.renato.ticketmania.dao.Ticket;
import com.renato.ticketmania.dto.requests.CreateTicketDto;
import com.renato.ticketmania.dto.responses.TagDto;
import com.renato.ticketmania.dto.responses.TicketDto;
import com.renato.ticketmania.dto.responses.TicketListDto;
import com.renato.ticketmania.exception.TagNotFoundException;
import com.renato.ticketmania.exception.TicketNotFoundException;
import com.renato.ticketmania.repository.TagRepository;
import com.renato.ticketmania.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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

    public Mono<TicketDto> createTicket(CreateTicketDto createTicketDto) {
        return createTicketDao(createTicketDto).flatMap(ticket -> ticketRepository.save(ticket).map(Ticket::toDto));
    }

    public Mono<TicketDto> getTicket(UUID id) {
        return ticketRepository.findById(id)
                .map(Ticket::toDto)
                .switchIfEmpty(Mono.error(new TicketNotFoundException("Ticket not found")));
    }

    public Mono<TicketDto> deleteTicket(UUID id) {
        return ticketRepository.findById(id)
                .switchIfEmpty(Mono.error(new TicketNotFoundException("Ticket not found")))
                .flatMap(ticket -> ticketRepository.delete(ticket).map(_ -> ticket.toDto()));
    }

    public Mono<TicketListDto> getAllTickets() {
        return ticketRepository.findAll()
                .map(Ticket::toDto)
                .collectList()
                .map(TicketListDto::new);
    }

    private Mono<Ticket> createTicketDao(CreateTicketDto createTicketDto) {
        var tagIdList = createTicketDto.tags().stream().map(TagDto::getId).toList();
        return tagRepository.findAllById(tagIdList)
            .collectList()
            .map(resultTags -> {
                var foundIds = resultTags.stream().map(Tag::getId).toList();
                var missingTags = tagIdList.stream()
                        .filter(id -> !foundIds.contains(id)).toList();
                if (!missingTags.isEmpty()) {
                    throw new TagNotFoundException(STR."Tags with IDs \{missingTags} are missing");
                }
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
                        resultTags,
                        emptyList()
                );
            });
    }
}
