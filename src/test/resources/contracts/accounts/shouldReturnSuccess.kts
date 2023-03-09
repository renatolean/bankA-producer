package contracts.accounts

import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    description = "should return 200 and response"
    request {
        method = GET
        url = url("/api/v1/banks/BankA/accounts/111c6065-a3e9-30bc-be6b-2e59da52bf2a")
        headers {
            contentType = APPLICATION_JSON
        }
    }
    response {
        status = OK
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(
                mapOf(
                    "id" to v(fromRequest().path(5)),
                    "iban" to v("AE290335945653798219586"),
                    "account_number" to v("5945653798219586")
                )
        )
    }
}
