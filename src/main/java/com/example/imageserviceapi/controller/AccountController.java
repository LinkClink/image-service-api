package com.example.imageserviceapi.controller;

import java.util.Optional;
import javax.validation.Valid;
import com.example.imageserviceapi.model.Account;
import com.example.imageserviceapi.model.dto.request.AccountRequestDto;
import com.example.imageserviceapi.model.dto.responce.AccountResponseDto;
import com.example.imageserviceapi.service.AccountService;
import com.example.imageserviceapi.service.mapper.AccountMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @PostMapping("/update/{id}")
    public AccountResponseDto update(@PathVariable Long id,
                                     @RequestBody @Valid AccountRequestDto dto) {
        Account account = accountMapper.mapToModel(dto);
        account.setId(id);
        return accountMapper.mapToDto(accountService.save(account));
    }

    @DeleteMapping
    @PostMapping("/delete/{email}")
    public AccountResponseDto delete(@PathVariable String email) {
        Optional<Account> account = accountService.getByEmail(email);
        if (account.isPresent()) {
            accountService.delete(account.get());
            return accountMapper.mapToDto(account.get());
        }
        throw new RuntimeException("Can`t find account with this email: " + email);
    }
}
