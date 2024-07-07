package com.renato.ticketmania.service;

import com.renato.ticketmania.dao.Tag;
import com.renato.ticketmania.dto.TagDto;
import com.renato.ticketmania.exception.TagAlreadyExistsException;
import com.renato.ticketmania.exception.TagNotFoundException;
import com.renato.ticketmania.repository.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Slf4j
@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public TagDto createTag(TagDto tagDto) {
        if (tagRepository.findByName(tagDto.getName()).isPresent()){
            throw new TagAlreadyExistsException("Tag with name " + tagDto.getName() + " already exists");
        }

        log.info(tagDto.getName());
        var tag = new Tag(randomUUID(), tagDto.getName());
        return tagRepository.save(tag).toDto();
    }

    public UUID deleteTag(UUID id){
        var tag = findTagById(id);
        tagRepository.delete(tag);
        return id;
    }

    public TagDto updateTag(UUID id, TagDto tagDto) {
        if (tagDto.getId() != null && !id.equals(tagDto.getId())) {
            throw new RuntimeException("Ids do not match, check request");
        }

        var tag = findTagById(id);
        tag.setName(tagDto.getName());
        tagRepository.save(tag);
        return tag.toDto();
    }

    public List<TagDto> getAll() {
        return tagRepository.findAll().stream().map(Tag::toDto).toList();
    }

    private Tag findTagById(UUID id) {
        return tagRepository.findById(id)
                .orElseThrow(
                        () -> new TagNotFoundException("Tag with id " + id + " does not exist")
                );
    }
}
