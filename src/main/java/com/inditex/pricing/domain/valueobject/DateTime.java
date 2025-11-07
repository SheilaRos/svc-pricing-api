package com.inditex.pricing.domain.valueobject;

import com.inditex.pricing.domain.exception.DateTimeCannotBeNullException;
import com.inditex.pricing.domain.exception.DateTimeInvalidValueException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DateTime {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
    private final LocalDateTime value;

    private DateTime(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    public static DateTime of(LocalDateTime date) {
        if (date == null) {
            throw new DateTimeCannotBeNullException();
        }

        return new DateTime(date);
    }

    public static DateTime of(String date) {
        LocalDateTime localDateTime = getLocalDateTimeFromString(date);

        return new DateTime(localDateTime);
    }

    private static LocalDateTime getLocalDateTimeFromString(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new DateTimeCannotBeNullException();
        }

        try {
            return LocalDateTime.parse(date, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new DateTimeInvalidValueException(date, FORMATTER.toString());
        }
    }
}
