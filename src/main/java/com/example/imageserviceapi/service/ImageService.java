package com.example.imageserviceapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.imageserviceapi.model.Image;
import com.example.imageserviceapi.model.Tag;

public interface ImageService {
    Image save(Image image);

    Image update(Image image);

    void delete(Image image);

    Optional<Image> getById(Long id);

    List<Image> findByTags(Set<Tag> tags);
}
