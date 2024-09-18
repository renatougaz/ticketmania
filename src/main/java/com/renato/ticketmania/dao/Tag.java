package com.renato.ticketmania.dao;

import com.renato.ticketmania.dto.responses.TagDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class Tag {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;

    public Tag() {}

    public TagDto toDto() {
        return new TagDto(id, name);
    }
}
