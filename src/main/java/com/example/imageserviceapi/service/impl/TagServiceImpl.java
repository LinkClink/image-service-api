package com.example.imageserviceapi.service.impl;

import java.util.Optional;
import com.example.imageserviceapi.model.Tag;
import com.example.imageserviceapi.repository.TagRepository;
import com.example.imageserviceapi.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void delete(Tag tag) {
        tagRepository.delete(tag);
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Optional<Tag> findByName(String name) {
        return Optional.ofNullable(tagRepository.findByName(name));
    }
}
