package ugaz.renato.ticketmania.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import ugaz.renato.ticketmania.dto.TicketDto;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static java.util.UUID.randomUUID;

@Entity
@Slf4j
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    UUID id;
    String title;
    String description;
    String stage;
//    List<String> tags;
//    List<String> comments;

    public Ticket() {}

    public TicketDto toDto() {
        var ticket =  new TicketDto(
                id,
                title,
                description,
                stage,
                emptyList(),
                emptyList()
        );

        log.info("ticket id: {}", ticket.id());
        return ticket;
    }
}
