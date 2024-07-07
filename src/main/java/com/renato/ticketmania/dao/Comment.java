package com.renato.ticketmania.dao;

import com.renato.ticketmania.dto.CommentDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String content;
    LocalDateTime dateTime;
    String author;

    public CommentDto toDto() {
        return new CommentDto(
                id,
                content,
                dateTime,
                author
        );
    }

}
