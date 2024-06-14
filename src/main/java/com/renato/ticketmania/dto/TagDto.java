package com.renato.ticketmania.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class TagDto {
    UUID id;
    @NotBlank String name;
}
