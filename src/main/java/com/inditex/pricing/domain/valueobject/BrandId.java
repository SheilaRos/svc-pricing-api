package com.inditex.pricing.domain.valueobject;

public final class BrandId {
    private final long value;

    private BrandId(long value) {
        this.value = value;
    }

    public static BrandId of(long id) {
        return new BrandId(id);
    }

    public long getValue() {
        return value;
    }
}
