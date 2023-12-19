package com.atalibdev.customerservice.request;

public record UpdateCustomerRequest(
        String firstName,
        String lastName,
        String email) {
}
