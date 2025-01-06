package com.renato.ticketmania.dto.requests;

import jakarta.validation.constraints.NotBlank;

public record CreateBoardDto(
        @NotBlank String title,
        @NotBlank String owner
) {
}
