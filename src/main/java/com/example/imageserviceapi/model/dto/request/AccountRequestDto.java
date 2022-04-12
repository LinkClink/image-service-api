package com.example.imageserviceapi.model.dto.request;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountRequestDto {
    @NotNull
    private String fullName;
    @NotNull
    private String password;
    @Column(unique = true)
    @Email
    private String email;
}
