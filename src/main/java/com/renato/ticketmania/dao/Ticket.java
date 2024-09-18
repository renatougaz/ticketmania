package com.renato.ticketmania.dao;

import com.renato.ticketmania.dto.responses.TicketDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

//@Entity
@Slf4j
@AllArgsConstructor
//@Table(name = "tickets")
public class Ticket {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String title;
    String description;
    String stage;
    String author;
    String assignee;
    Boolean important;
    String pointType;
    String pointValue;
    List<Tag> tags;
    List<Comment> comments;

    public Ticket(){}

    public TicketDto toDto() {
        return new TicketDto(
                id,
                title,
                description,
                stage,
                author,
                assignee,
                important,
                pointType,
                pointValue,
                tags.stream().map(Tag::toDto).toList(),
                comments.stream().map(Comment::toDto).toList()
        );
    }
}
