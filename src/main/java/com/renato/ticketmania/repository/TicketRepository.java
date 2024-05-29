package com.renato.ticketmania.repository;

import com.renato.ticketmania.dao.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {

}
