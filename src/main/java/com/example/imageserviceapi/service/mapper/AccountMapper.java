package com.example.imageserviceapi.service.mapper;

import java.util.stream.Collectors;
import com.example.imageserviceapi.model.Account;
import com.example.imageserviceapi.model.Image;
import com.example.imageserviceapi.model.dto.request.AccountRequestDto;
import com.example.imageserviceapi.model.dto.responce.AccountResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account mapToModel(AccountRequestDto dto) {
        Account account = new Account();
        account.setPassword(dto.getPassword());
        account.setEmail(dto.getEmail());
        account.setFullName(dto.getFullName());
        return account;
    }

    public AccountResponseDto mapToDto(Account account) {
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setEmail(account.getEmail());
        accountResponseDto.setFullName(account.getFullName());
        accountResponseDto.setId(account.getId());
        if (account.getImages() != null) {
            accountResponseDto.setImagesId(account.getImages()
                    .stream()
                    .map(Image::getId)
                    .collect(Collectors.toList()));
        }
        return accountResponseDto;
    }
}
