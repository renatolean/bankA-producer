package contracts.accounts

import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    description = "should return 500 and response"
    request {
        method = GET
        url = url("/api/v1/banks/bankA/account/000c6065-a3e9-30bc-be6b-2e59da52bf2a")
        headers {
            contentType = APPLICATION_JSON
        }
    }
    response {
        status = NOT_FOUND
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(
                mapOf(
                        "timestamp" to anyIso8601WithOffset,
                        "status_code" to "INTERNAL_SERVER_ERROR",
                        "message" to "Unable to categorize transactions due to oops",
                        "request" to anyAlphaUnicode
                )
        )
    }
}
