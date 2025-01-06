package com.renato.ticketmania.service;

import com.renato.ticketmania.dao.Tag;
import com.renato.ticketmania.dto.responses.TagDto;
import com.renato.ticketmania.exception.AlreadyExistsException;
import com.renato.ticketmania.exception.TagNotFoundException;
import com.renato.ticketmania.repository.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static java.util.UUID.randomUUID;

@Slf4j
@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public Mono<TagDto> createTag(TagDto tagDto) {
        if (tagRepository.findByName(tagDto.getName()).isPresent()){
            throw new AlreadyExistsException("Tag with name " + tagDto.getName() + " already exists");
        }

        log.info(tagDto.getName());
        var tag = new Tag(randomUUID(), tagDto.getName());
        return tagRepository.save(tag).map(Tag::toDto) ;
    }

    public Mono<UUID> deleteTag(UUID id){
        return findTagById(id)
            .switchIfEmpty(Mono.error(new TagNotFoundException("Entity not found with id: " + id)))
            .flatMap(tag -> tagRepository.delete(tag)).map(_ -> id);
    }

    public Mono<TagDto> updateTag(UUID id, TagDto tagDto) {
        if (tagDto.getId() != null && !id.equals(tagDto.getId())) {
            throw new RuntimeException("Ids do not match, check request");
        }
        return findTagById(id)
            .switchIfEmpty(Mono.error(new TagNotFoundException("Entity not found with id: " + id)))
            .flatMap(tag -> {
                tag.setName(tagDto.getName());
                return tagRepository.save(tag);
            }).map(Tag::toDto);
    }

    public Flux<TagDto> getAll() {
        return tagRepository.findAll().map(Tag::toDto);
    }

    private Mono<Tag> findTagById(UUID id) {
        return tagRepository.findById(id)
            .switchIfEmpty(Mono.error(new TagNotFoundException("Entity not found with id: " + id)));
    }
}
