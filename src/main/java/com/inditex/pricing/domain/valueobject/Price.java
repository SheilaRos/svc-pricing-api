package com.inditex.pricing.domain.valueobject;

import com.inditex.pricing.domain.exception.AmountAndCurrencyCannotBeNullException;

public final class Price {
    private final Amount amount;
    private final Currency currency;

    private Price(Amount amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Price of(Amount amount, Currency currency) {
        if (amount == null || currency == null) {
            throw new AmountAndCurrencyCannotBeNullException();
        }

        return new Price(amount, currency);
    }

    public Amount getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
