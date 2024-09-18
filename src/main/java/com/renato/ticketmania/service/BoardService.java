package com.renato.ticketmania.service;

import com.renato.ticketmania.dao.Board;
import com.renato.ticketmania.dto.requests.CreateBoardDto;
import com.renato.ticketmania.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.UUID.randomUUID;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;
    @PostConstruct
    public void init() {

    }

    public Mono<Board> createBoard(CreateBoardDto createBoardDto) {
        var board = new Board(randomUUID(),
                createBoardDto.title(),
                createBoardDto.title(),
                emptySet(),
                emptyList());

        return boardRepository.save(board);
    }
}
