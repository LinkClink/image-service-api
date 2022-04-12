package com.example.imageserviceapi.model.dto.responce;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private List<Long> imagesId;
}
