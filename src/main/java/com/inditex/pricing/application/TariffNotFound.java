package com.inditex.pricing.application;

public final class TariffNotFound extends RuntimeException {
    private static final String MESSAGE = "Tariff not found.";

    public TariffNotFound() {
        super(MESSAGE);
    }
}
