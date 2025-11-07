package com.inditex.pricing.domain.exception;

public final class InvalidCurrencyException extends ValidationException {
    private static final String MESSAGE = "Invalid currency %s.";

    public InvalidCurrencyException(String currency) {
        super(String.format(MESSAGE, currency));
    }
}
