Running example, Bank API

To aid our article, we will be using a running example. Requirements are:
- SpringBoot 3.X
- Java 17
- Lombok
- WebFlux
- Spring Cloud Contracts 4.X


```mermaid
    sequenceDiagram
    autonumber
    actor U as User
    Participant BA as BankApp
    Participant B as Bank A
    
	U->>BA: Get Account details
    BA->>B: GET <host>/api/v1/banks/BankA/accounts/{account_id}  
    B->>BA: <AccountDetails>
    BA->>U: AccountDetails 
```