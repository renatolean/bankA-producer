package com.lean.tech.services;

import com.lean.tech.exceptions.AccountNotFoundException;
import com.lean.tech.models.AccountDetails;
import com.lean.tech.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Mono<AccountDetails> getAccount(UUID id) {
        return accountRepository.findAccount(id)
                .switchIfEmpty(Mono.error(new AccountNotFoundException()));
    }
}
