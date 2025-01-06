package com.renato.ticketmania.repository;


import com.renato.ticketmania.dao.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
interface BoardRepository extends ReactiveMongoRepository<Board, UUID> {
    Mono<Board> findByTitleAndOwner(String title, String owner);

}

