package com.inditex.pricing.domain.exception;

public final class CurrencyCannotBeNullOrEmptyException extends ValidationException {
    private static final String MESSAGE = "Currency cannot be null or empty.";

    public CurrencyCannotBeNullOrEmptyException() {
        super(MESSAGE);
    }
}
