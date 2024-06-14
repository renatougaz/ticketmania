package com.renato.ticketmania.api;

import com.renato.ticketmania.dto.TagDto;
import com.renato.ticketmania.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService service;

    @PostMapping("/create")
    public TagDto createTag(@RequestBody TagDto tagDto) {
        return service.CreateTag(tagDto);
    }

    @GetMapping("/all")
    public List<TagDto> getAll() {
        return service.getAll();
    }
}
