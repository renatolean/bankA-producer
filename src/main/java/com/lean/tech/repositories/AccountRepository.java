package com.lean.tech.repositories;

import com.lean.tech.models.AccountDetails;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@Repository
public class AccountRepository {

    Map<UUID, AccountDetails> accounts = Map.of(UUID.fromString("111c6065-a3e9-30bc-be6b-2e59da52bf2a"), AccountDetails.builder()
                    .id(UUID.fromString("111c6065-a3e9-30bc-be6b-2e59da52bf2a"))
                    .iban("AE290335945653798219586")
                    .accountNumber("5945653798219586")
            .build());

    public Mono<AccountDetails> findAccount(UUID id) {
        return Mono.fromSupplier(() -> accounts.getOrDefault(id, null));
    }
}
