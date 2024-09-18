package com.renato.ticketmania.repository;


import com.renato.ticketmania.dao.Board;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoardRepository extends ReactiveMongoRepository<Board, UUID> { }
