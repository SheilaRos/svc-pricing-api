package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.exception.CurrencyCannotBeNullOrEmptyException;
import com.inditex.pricing.domain.exception.InvalidCurrencyException;
import com.inditex.pricing.domain.valueobject.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @Test
    void createCurrencySuccessfully() {
        Currency currency = Currency.of("USD");
        assertNotNull(currency);
        assertEquals(Currency.USD, currency);
        assertEquals("United States Dollar", currency.getName());
        assertEquals("USD", currency.getValue());
    }

    @Test
    void throwExceptionWhenIsNull() {
        assertThrows(CurrencyCannotBeNullOrEmptyException.class, () -> Currency.of(null));
    }

    @Test
    void throwExceptionWhenInvalidCode() {
        assertThrows(InvalidCurrencyException.class, () -> Currency.of("XXX"));
    }
}
