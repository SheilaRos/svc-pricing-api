package com.inditex.pricing.domain.exception;

public final class AmountAndCurrencyCannotBeNullException extends ValidationException {
    private static final String MESSAGE = "Amount and Currency cannot be null.";

    public AmountAndCurrencyCannotBeNullException() {
        super(MESSAGE);
    }
}
