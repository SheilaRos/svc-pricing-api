package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.exception.AmountAndCurrencyCannotBeNullException;
import com.inditex.pricing.domain.valueobject.Amount;
import com.inditex.pricing.domain.valueobject.Currency;
import com.inditex.pricing.domain.valueobject.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void createPriceWithValidAmountAndCurrencySuccessfully() {
        Amount amount = Amount.of(new BigDecimal("100.00"));
        Currency currency = Currency.EUR;
        Price price = Price.of(amount, currency);
        assertNotNull(price);
        assertEquals(amount, price.getAmount());
        assertEquals(currency, price.getCurrency());
    }

    @Test
    void throwExceptionWhenAmountIsNull() {
        Currency currency = Currency.USD;
        assertThrows(AmountAndCurrencyCannotBeNullException.class, () -> Price.of(null, currency));
    }

    @Test
    void throwExceptionWhenCurrencyIsNull() {
        Amount amount = Amount.of(new BigDecimal("50.00"));
        assertThrows(AmountAndCurrencyCannotBeNullException.class, () -> Price.of(amount, null));
    }
}
