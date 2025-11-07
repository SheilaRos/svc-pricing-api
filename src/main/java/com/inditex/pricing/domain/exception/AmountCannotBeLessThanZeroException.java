package com.inditex.pricing.domain.exception;

import java.math.BigDecimal;

public final class AmountCannotBeLessThanZeroException extends ValidationException {
    private static final String MESSAGE = "Amount %s cannot be less than 0.";

    public AmountCannotBeLessThanZeroException(BigDecimal amount) {
        super(String.format(MESSAGE, amount.toString()));
    }
}
