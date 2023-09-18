package com.khomsi.customer.model.request;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
