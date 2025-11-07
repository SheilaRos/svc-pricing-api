package com.inditex.pricing.domain.valueobject;

import com.inditex.pricing.domain.exception.AmountCannotBeEmptyOrNullException;
import com.inditex.pricing.domain.exception.AmountCannotBeLessThanZeroException;
import com.inditex.pricing.domain.exception.InvalidAmountFormatException;

import java.math.BigDecimal;

public final class Amount {
    private static final BigDecimal MIN_AMOUNT = BigDecimal.ZERO;
    private final BigDecimal value;

    private Amount(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static Amount of(BigDecimal value) {
        return new Amount(value);
    }

    public static Amount of(String value) {
        BigDecimal amount = getBigDecimalFromString(value);

        return new Amount(amount);
    }

    private static BigDecimal getBigDecimalFromString(String value) {
        if(value == null || value.trim().isEmpty()) {
            throw new AmountCannotBeEmptyOrNullException();
        }

        try {
            BigDecimal amount = new BigDecimal(value);
            validate(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new InvalidAmountFormatException(value);
        }
    }

    private static void validate(BigDecimal value) {
        if (MIN_AMOUNT.compareTo(value) > 0) {
            throw new AmountCannotBeLessThanZeroException(value);
        }
    }
}
