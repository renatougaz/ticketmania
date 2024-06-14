package com.renato.ticketmania.api;

import com.renato.ticketmania.dto.TicketDto;
import com.renato.ticketmania.service.TicketService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService service;

    @PostMapping("/create")
    public TicketDto createTicket(@Valid @RequestBody TicketDto ticketDto) {
        var result = service.createTicket(ticketDto);
        log.info("createTicket returned ticket with title {} ", result.title());
        return result;
    }

    @GetMapping("/{id}")
    public TicketDto getTicket(@PathVariable("id") UUID id) {
        return service.getTicket(id);
    }

    @DeleteMapping("/{id}")
    public TicketDto deleteTicket(@PathVariable("id") UUID id) {
        return service.deleteTicket(id);
    }

    @GetMapping("/all")
    public List<TicketDto> getAllTickets() {
        return service.getAllTickets();
    }
}
