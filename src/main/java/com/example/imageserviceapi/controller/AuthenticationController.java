package com.example.imageserviceapi.controller;

import javax.validation.Valid;
import com.example.imageserviceapi.model.Account;
import com.example.imageserviceapi.model.dto.request.AccountRequestDto;
import com.example.imageserviceapi.model.dto.responce.AccountResponseDto;
import com.example.imageserviceapi.service.AccountService;
import com.example.imageserviceapi.service.mapper.AccountMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public AuthenticationController(AccountService accountService,
                                    AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @PostMapping("/register")
    public AccountResponseDto register(@RequestBody @Valid AccountRequestDto dto) {
        Account account = accountMapper.mapToModel(dto);
        if (accountService.getByEmail(account.getEmail()).isEmpty()) {
            return accountMapper.mapToDto(accountService.save(account));
        }
        throw new RuntimeException("Email already exits: " + account.getEmail());
    }
}
