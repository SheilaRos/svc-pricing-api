package com.inditex.pricing.domain.exception;

public final class AmountCannotBeEmptyOrNullException extends ValidationException {
    private static final String MESSAGE = "Amount cannot be empty or null.";

    public AmountCannotBeEmptyOrNullException() {
        super(MESSAGE);
    }
}
