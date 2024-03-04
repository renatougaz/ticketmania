package ugaz.renato.ticketmania.api;

import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ugaz.renato.ticketmania.dto.TicketDto;
import ugaz.renato.ticketmania.service.TicketService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static java.util.UUID.randomUUID;

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
