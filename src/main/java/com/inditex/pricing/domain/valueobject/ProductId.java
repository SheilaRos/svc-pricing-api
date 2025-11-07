package com.inditex.pricing.domain.valueobject;

public final class ProductId {
    private final long value;

    private ProductId(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public static ProductId of(long value) {
        return new ProductId(value);
    }
}
