package com.example.imageserviceapi.service.mapper;

import com.example.imageserviceapi.model.Tag;
import com.example.imageserviceapi.model.dto.request.TagRequestDto;
import com.example.imageserviceapi.model.dto.responce.TagResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    public Tag mapToModel(TagRequestDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        return tag;
    }

    public TagResponseDto mapToDto(Tag tag) {
        TagResponseDto tagResponseDto = new TagResponseDto();
        tagResponseDto.setId(tag.getId());
        tagResponseDto.setName(tag.getName());
        return tagResponseDto;
    }
}
