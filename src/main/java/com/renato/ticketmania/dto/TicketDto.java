package com.renato.ticketmania.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record TicketDto(
        UUID id,
        @NotBlank String title,
        String description,
        String stage,
        @NotNull List<TagDto> tags,
        List<CommentDto> comments
) {

}
