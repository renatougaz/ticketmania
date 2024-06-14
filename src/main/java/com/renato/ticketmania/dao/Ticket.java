package com.renato.ticketmania.dao;

import com.renato.ticketmania.dto.TicketDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.MemoryAddress;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.hibernate.annotations.Type;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static java.util.UUID.randomUUID;

@Entity
@Slf4j
@AllArgsConstructor
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String title;
    String description;
    String stage;
    @ManyToMany List<Tag> tags;
    @OneToMany List<Comment> comments;

    public Ticket(){}

    public TicketDto toDto() {
        return new TicketDto(
                id,
                title,
                description,
                stage,
                tags.stream().map(Tag::toDto).toList(),
                comments.stream().map(Comment::toDto).toList()
        );
    }
}
