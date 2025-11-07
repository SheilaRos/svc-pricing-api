package com.inditex.pricing.domain.valueobject;

import com.inditex.pricing.domain.exception.BrandNameCannotBeNullException;

public final class BrandName {
    private final String value;

    private BrandName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BrandName of(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new BrandNameCannotBeNullException();
        }

        return new BrandName(name);
    }
}
