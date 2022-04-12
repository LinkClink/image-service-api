package com.example.imageserviceapi.service;

import java.util.Optional;
import com.example.imageserviceapi.model.Tag;

public interface TagService {
    Tag create(Tag tag);

    void delete(Tag tag);

    Optional<Tag> findById(Long id);

    Optional<Tag> findByName(String name);
}
