package com.renato.ticketmania.dto.requests;

import com.renato.ticketmania.dto.responses.TagDto;

import java.util.List;
import java.util.Optional;

public record BoardSearch (
        Optional<String> title,
        Optional<String> owner,
        Optional<Integer> numberOfTickets,
        Optional<List<String>> tags
) { }
