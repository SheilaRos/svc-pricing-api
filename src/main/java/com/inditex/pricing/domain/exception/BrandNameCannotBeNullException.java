package com.inditex.pricing.domain.exception;

public final class BrandNameCannotBeNullException extends ValidationException {
    private static final String MESSAGE = "Brand name cannot be null or empty.";

    public BrandNameCannotBeNullException() {
        super(MESSAGE);
    }
}
