package com.inditex.pricing.domain.exception;

public final class DateTimeCannotBeNullException extends ValidationException {
    private static final String MESSAGE = "Date cannot be null.";

    public DateTimeCannotBeNullException() {
        super(MESSAGE);
    }
}
