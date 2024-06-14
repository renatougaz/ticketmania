package com.renato.ticketmania.dao;

import com.renato.ticketmania.dto.TagDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.UUID;

@Entity
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
