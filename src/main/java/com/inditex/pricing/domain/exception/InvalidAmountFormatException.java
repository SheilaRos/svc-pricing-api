package com.inditex.pricing.domain.exception;

public final class InvalidAmountFormatException extends ValidationException {
    private static final String MESSAGE = "Invalid Amount %s format. Amount needs to be a decimal number.";

    public InvalidAmountFormatException(String amount) {
        super(String.format(MESSAGE, amount));
    }
}
