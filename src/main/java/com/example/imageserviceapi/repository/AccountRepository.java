package com.example.imageserviceapi.repository;

import com.example.imageserviceapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByEmail(String email);
}
