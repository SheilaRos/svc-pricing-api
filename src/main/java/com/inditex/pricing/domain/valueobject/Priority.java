package com.inditex.pricing.domain.valueobject;

public final class Priority {
    private final long value;

    private Priority(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public static Priority of(long value) {
        return new Priority(value);
    }
}
