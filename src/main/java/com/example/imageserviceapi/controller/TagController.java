package com.example.imageserviceapi.controller;

import java.util.Optional;
import com.example.imageserviceapi.model.Tag;
import com.example.imageserviceapi.model.dto.request.TagRequestDto;
import com.example.imageserviceapi.model.dto.responce.TagResponseDto;
import com.example.imageserviceapi.service.TagService;
import com.example.imageserviceapi.service.mapper.TagMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;
    private final TagMapper tagMapper;

    public TagController(TagService tagService, TagMapper tagMapper) {
        this.tagService = tagService;
        this.tagMapper = tagMapper;
    }

    @PostMapping("/save")
    public TagResponseDto save(@RequestBody TagRequestDto dto) {
        return tagMapper.mapToDto(tagService.create(tagMapper.mapToModel(dto)));
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findById(id);
        if (tag.isPresent()) {
            tagService.delete(tag.get());
            return "Success delete " + tagMapper.mapToDto(tag.get());
        }
        return "Can`t find tag with this id: " + id;
    }
}
