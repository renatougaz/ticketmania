package com.renato.ticketmania.dao;

import com.renato.ticketmania.dto.responses.TagDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;

    public Tag() {}

    public TagDto toDto() {
        return new TagDto(id, name);
    }
}
