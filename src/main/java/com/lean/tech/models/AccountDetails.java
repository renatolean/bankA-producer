package com.lean.tech.models;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record AccountDetails(UUID id, String iban, String accountNumber) {
}
