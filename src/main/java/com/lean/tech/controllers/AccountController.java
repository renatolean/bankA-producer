package com.lean.tech.controllers;

import com.lean.tech.models.AccountDetails;
import com.lean.tech.services.AccountService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/banks/BankA/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{account_id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "404", description = "Account Not Found")
    @ApiResponse(responseCode = "500", description = "Something went wrong in service")
    public Mono<AccountDetails> getAccount(@RequestBody @Valid @PathVariable("account_id") UUID accountId) {
        return accountService.getAccount(accountId);
    }
}
