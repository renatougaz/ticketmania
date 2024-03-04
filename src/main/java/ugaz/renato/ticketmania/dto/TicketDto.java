package ugaz.renato.ticketmania.dto;


import jakarta.validation.constraints.NotBlank;
import ugaz.renato.ticketmania.dao.Ticket;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public record TicketDto(
        UUID id,
        @NotBlank
        String title,
        String description,
        String stage,
        List<String> tags,
        List<String> comments
) {
    public Ticket toDao() {
        return new Ticket(
                randomUUID(),
                title,
                description,
                stage
//                tags,
//                comments
        );
    }
}
