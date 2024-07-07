package com.renato.ticketmania.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class CommentDto {

    @NotBlank UUID id;
    @NotBlank String  content;
    @NotBlank LocalDateTime dateTime;
    @NotBlank String author;
}
