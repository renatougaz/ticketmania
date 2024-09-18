package com.renato.ticketmania.api;

import com.renato.ticketmania.dto.responses.TagDto;
import com.renato.ticketmania.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService service;

    @PostMapping("/create")
    public Mono<TagDto> createTag(@RequestBody TagDto tagDto) {
        return service.createTag(tagDto);
    }

    @DeleteMapping("/{id}")
    public Mono<UUID> deleteTag(@PathVariable UUID id) {
        return service.deleteTag(id);
    }

    @PutMapping("/{id}")
    public Mono<TagDto> updateTag(@PathVariable UUID id, @RequestBody TagDto tagDto) {
        return service.updateTag(id, tagDto);
    }

    @GetMapping("/all")
    public Flux<TagDto> getAll() {
        return service.getAll();
    }
}
