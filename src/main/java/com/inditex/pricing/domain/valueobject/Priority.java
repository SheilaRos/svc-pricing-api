package com.inditex.pricing.domain.valueobject;

public final class Priority {
    private final int value;

    private Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Priority of(int value) {
        return new Priority(value);
    }
}
