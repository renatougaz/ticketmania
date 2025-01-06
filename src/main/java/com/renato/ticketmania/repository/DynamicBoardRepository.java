package com.renato.ticketmania.repository;

import com.mongodb.internal.operation.AggregateOperation;
import com.renato.ticketmania.dao.Board;
import com.renato.ticketmania.dto.requests.BoardSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.aggregation.Aggregation;

import org.springframework.data.relational.core.mapping.AggregatePath;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;

@Service
public class DynamicBoardRepository {

    @Autowired
    BoardRepository simpleRepo;

    @Autowired
    ReactiveMongoTemplate mongoTemplate;


    public Mono<Board> findByTitleAndOwner(String title, String owner) {
        return simpleRepo.findByTitleAndOwner(title, owner);
    }

    public Mono<Board> save(Board board) {
        return simpleRepo.save(board);
    }

    public Flux<Board> findAll() {
        return simpleRepo.findAll();
    }

    public Flux<Board> search(BoardSearch search) {
        List<AggregationOperation> operations = new ArrayList<>();

        search.title().ifPresent(title ->
                operations.add(match(Criteria.where("title").is(title)))
        );
        search.owner().ifPresent(owner ->
                operations.add(match(Criteria.where("owner").is(owner)))
        );
        search.numberOfTickets().ifPresent(numberOfTickets ->
                operations.add(match(Criteria.where("tickets").size(numberOfTickets)))
        );
        search.tags().ifPresent(tags ->
                operations.add(match(Criteria.where("column").in(tags)))
        );

        var aggregation = Aggregation.newAggregation(operations);

        return mongoTemplate.aggregate(aggregation, "board", Board.class);
    }
}
