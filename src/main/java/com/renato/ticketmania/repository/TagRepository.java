package com.renato.ticketmania.repository;

import com.renato.ticketmania.dao.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TagRepository extends ReactiveMongoRepository<Tag, UUID> {
    Optional<Tag> findByName(String name);
}

