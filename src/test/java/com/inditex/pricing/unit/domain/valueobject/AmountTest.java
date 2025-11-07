package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.exception.AmountCannotBeEmptyOrNullException;
import com.inditex.pricing.domain.exception.AmountCannotBeLessThanZeroException;
import com.inditex.pricing.domain.exception.InvalidAmountFormatException;
import com.inditex.pricing.domain.valueobject.Amount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {

    @Test
    void createAmountFromBigDecimalSuccessfully() {
        BigDecimal expected = new BigDecimal("100.50");
        Amount amount = Amount.of(expected);
        assertNotNull(amount);
        assertEquals(expected, amount.getValue());
    }

    @Test
    void CreateAmountFromValidStringSuccessfully() {
        Amount amount = Amount.of("50.00");
        assertNotNull(amount);
        assertEquals(new BigDecimal("50.00"), amount.getValue());
    }

    @Test
    void throwExceptionWhenStringIsNull() {
        assertThrows(AmountCannotBeEmptyOrNullException.class, () -> Amount.of((String) null));
    }

    @Test
    void throwExceptionWhenStringIsEmpty() {
        assertThrows(AmountCannotBeEmptyOrNullException.class, () -> Amount.of(" "));
    }

    @Test
    void throwExceptionWhenStringIsInvalidFormat() {
        assertThrows(InvalidAmountFormatException.class, () -> Amount.of("abc"));
    }

    @Test
    void throwExceptionWhenAmountIsNegative() {
        assertThrows(AmountCannotBeLessThanZeroException.class, () -> Amount.of("-10.00"));
    }
}
