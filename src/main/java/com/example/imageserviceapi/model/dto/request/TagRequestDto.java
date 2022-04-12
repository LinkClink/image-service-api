package com.example.imageserviceapi.model.dto.request;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TagRequestDto {
    @NotNull
    @Column(unique = true)
    private String name;
}
