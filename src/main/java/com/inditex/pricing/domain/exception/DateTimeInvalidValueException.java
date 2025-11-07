package com.inditex.pricing.domain.exception;

public final class DateTimeInvalidValueException extends ValidationException {
    private static final String MESSAGE = "Date %s has invalid format %s.";

    public DateTimeInvalidValueException(String date, String format) {
        super(String.format(MESSAGE, date, format));
    }
}
