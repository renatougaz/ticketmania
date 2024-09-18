package com.renato.ticketmania.dto.requests;

import com.renato.ticketmania.dto.responses.TagDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateTicketDto(
        @NotBlank String title,
        String description,
        String stage,
        String author,
        String assignee,
        Boolean important,
        String pointsType,
        String pointValue,
        @NotNull List<TagDto> tags
) {

}
