package com.example.imageserviceapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.imageserviceapi.model.Image;
import com.example.imageserviceapi.model.Tag;
import com.example.imageserviceapi.repository.ImageRepository;
import com.example.imageserviceapi.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image update(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void delete(Image image) {
        imageRepository.delete(image);
    }

    @Override
    public Optional<Image> getById(Long id) {
        return Optional.of(imageRepository.getById(id));
    }

    @Override
    public List<Image> findByTags(Set<Tag> tags) {
        return imageRepository.findByTagsIn(tags);
    }
}
