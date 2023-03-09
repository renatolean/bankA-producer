package com.lean.tech;

import com.lean.tech.exceptions.AccountNotFoundException;
import com.lean.tech.models.AccountDetails;
import com.lean.tech.services.AccountService;
import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@WebFluxTest
public class RestContractsBase {

    private static final UUID KNOWN_ACCOUNT_ID = UUID.fromString("111c6065-a3e9-30bc-be6b-2e59da52bf2a");

    @Autowired
    private ApplicationContext context;

    @MockBean
    private AccountService accountService;

//    @SpyBean
//    private ExceptionsResponseEntityFactory exceptionsResponseEntityFactory;

    @BeforeEach
    @SneakyThrows
    void setUp() {
        when(accountService.getAccount(any())).thenAnswer(invocationOnMock -> {
            UUID accountId = (UUID) invocationOnMock.getArgument(0);
            if (KNOWN_ACCOUNT_ID.equals(accountId)) {
                return Mono.just(AccountDetails.builder()
                        .id(KNOWN_ACCOUNT_ID)
                        .iban("AE290335945653798219586")
                        .accountNumber("5945653798219586")
                        .build());
            } else {
                return Mono.error(new AccountNotFoundException());
            }
        });

        RestAssuredWebTestClient.applicationContextSetup(context);
    }
}
