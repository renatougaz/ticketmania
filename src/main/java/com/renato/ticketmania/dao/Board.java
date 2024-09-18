package com.renato.ticketmania.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@AllArgsConstructor
//@Entity
public class Board {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String title;
    String owner;
    Set<Ticket> tickets;
    List<String> column;
}
