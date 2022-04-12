package com.example.imageserviceapi.repository;

import java.util.List;
import java.util.Set;
import com.example.imageserviceapi.model.Image;
import com.example.imageserviceapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByTagsIn(Set<Tag> tags);
}
