package com.renato.ticketmania.dao;

import com.renato.ticketmania.dto.responses.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@Document
@Data
public class Board {
    @Id
    UUID id;
    String title;
    String owner;
    Set<Ticket> tickets;
    List<String> column;

    public BoardDto toDto() {
        return new BoardDto(
                id,
                title,
                owner,
                tickets.stream().distinct().map(Ticket::toDto).collect(Collectors.toSet()),
                column
        );
    }
}
