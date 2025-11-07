package com.inditex.pricing.domain.valueobject;

public final class TariffId {
    private final long value;

    private TariffId(long value) {
        this.value = value;
    }

    public static TariffId of(long id) {
        return new TariffId(id);
    }

    public long getValue() {
        return value;
    }
}
