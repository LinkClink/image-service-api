package com.example.imageserviceapi.service;

import java.util.Optional;
import com.example.imageserviceapi.model.Account;

public interface AccountService {

    Account update(Account account);

    Optional<Account> getByEmail(String email);

    Account save(Account account);

    void delete(Account account);
}
