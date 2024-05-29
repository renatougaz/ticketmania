package com.renato.ticketmania.api;

import com.renato.ticketmania.dto.TicketDto;
import com.renato.ticketmania.service.TicketService;
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

    @GetMapping("/test")
    public String getTest() {
        return "test string ";
    }

    @PostMapping("/create")
    public TicketDto createTicket(@RequestBody TicketDto ticketDto) {
        var result = service.createTicket(ticketDto);
        log.info("createTicket is returning {} ", result.title());
        return result;
    }

    @GetMapping("/ticket/{id}")
    public TicketDto getTicketDto(@PathVariable("id") UUID id) {
        return service.getTicket(id);
    }

    @GetMapping("/all")
    public List<TicketDto> getAllTickets() {
        return service.getAllTickets();
    }
}
