package com.inditex.pricing.application.exception;

public final class TariffNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Tariff not found.";

    public TariffNotFoundException() {
        super(MESSAGE);
    }
}
