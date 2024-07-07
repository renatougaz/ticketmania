package com.renato.ticketmania.api;

import com.renato.ticketmania.dto.TagDto;
import com.renato.ticketmania.service.TagService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService service;

    @PostMapping("/create")
    public TagDto createTag(@RequestBody TagDto tagDto) {
        return service.createTag(tagDto);
    }

    @DeleteMapping("/{id}")
    public UUID deleteTag(@PathVariable UUID id) {
        return service.deleteTag(id);
    }

    @PutMapping("/{id}")
    public TagDto updateTag(@PathVariable UUID id, @RequestBody TagDto tagDto) {
        return service.updateTag(id, tagDto);
    }

    @GetMapping("/all")
    public List<TagDto> getAll() {
        return service.getAll();
    }
}
