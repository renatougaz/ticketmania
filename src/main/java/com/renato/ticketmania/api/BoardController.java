package com.renato.ticketmania.api;


import com.renato.ticketmania.dao.Board;
import com.renato.ticketmania.dto.requests.BoardSearch;
import com.renato.ticketmania.dto.requests.CreateBoardDto;
import com.renato.ticketmania.dto.responses.BoardDto;
import com.renato.ticketmania.service.BoardService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService service;

    @PostMapping("/create")
    public Mono<BoardDto> create(@RequestBody @Valid CreateBoardDto createBoardDto) {
        return service.create(createBoardDto);
    }

    @GetMapping("/all")
    public Flux<BoardDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public Flux<BoardDto> search(@RequestBody BoardSearch boardSearch) {
        return service.search(boardSearch);

    }
}
