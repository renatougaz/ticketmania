package ugaz.renato.ticketmania.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ugaz.renato.ticketmania.dao.Ticket;
import ugaz.renato.ticketmania.dto.TicketDto;
import ugaz.renato.ticketmania.repository.TicketRepository;

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
