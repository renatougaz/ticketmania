package com.renato.ticketmania.service;

import com.renato.ticketmania.dao.Board;
import com.renato.ticketmania.dto.requests.BoardSearch;
import com.renato.ticketmania.dto.requests.CreateBoardDto;
import com.renato.ticketmania.dto.responses.BoardDto;
import com.renato.ticketmania.exception.AlreadyExistsException;
import com.renato.ticketmania.repository.DynamicBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.UUID.randomUUID;

@Service
public class BoardService {

//    @Autowired
//    ReactiveMongoTemplate mongoTemplate;

    @Autowired
    DynamicBoardRepository boardRepository;

    public Mono<BoardDto> create(CreateBoardDto createBoardDto) {
        return boardRepository.findByTitleAndOwner(createBoardDto.title(), createBoardDto.owner())
            .hasElement()
            .flatMap(exists -> {
                if (exists)
                    return Mono.error(new AlreadyExistsException(STR."Board with name \{createBoardDto.title()} already exists"));
                else {
                    var board = new Board(randomUUID(),
                            createBoardDto.title(),
                            createBoardDto.owner(),
                            emptySet(),
                            emptyList());
                    return boardRepository.save(board).map(Board::toDto);
                }
            });
    }

    public Flux<BoardDto> getAll() {
        return boardRepository.findAll().map(Board::toDto);
    }

    public Flux<BoardDto> search(BoardSearch boardSearch) {
        return boardRepository.search(boardSearch).map(Board::toDto);
    }
}
