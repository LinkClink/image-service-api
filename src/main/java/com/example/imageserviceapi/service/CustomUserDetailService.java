package com.example.imageserviceapi.service;

import java.util.Optional;
import com.example.imageserviceapi.model.Account;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final AccountService accountService;

    public CustomUserDetailService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Optional<Account> account = accountService.getByEmail(email);
        UserBuilder builder;
        if (account.isPresent()) {
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.password(account.get().getPassword());
            builder.roles("USER");
            return builder.build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
