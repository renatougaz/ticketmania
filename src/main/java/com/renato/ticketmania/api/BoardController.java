package com.renato.ticketmania.api;


import com.renato.ticketmania.dao.Board;
import com.renato.ticketmania.dto.requests.CreateBoardDto;
import com.renato.ticketmania.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/board")

public class BoardController {
    @Autowired
    BoardService service;

    public Mono<Board> createBoard(CreateBoardDto createBoardDto) {
        return service.createBoard(createBoardDto);
    }
}
