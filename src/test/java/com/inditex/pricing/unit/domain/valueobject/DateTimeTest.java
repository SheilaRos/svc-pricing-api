package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.exception.DateTimeCannotBeNullException;
import com.inditex.pricing.domain.exception.DateTimeInvalidValueException;
import com.inditex.pricing.domain.valueobject.DateTime;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeTest {

    @Test
    void createFromLocalDateTimeSuccessfully() {
        LocalDateTime now = LocalDateTime.now();
        DateTime dateTime = DateTime.of(now);
        assertNotNull(dateTime);
        assertEquals(now, dateTime.getValue());
    }

    @Test
    void createFromStringSuccessfully() {
        String validDate = "2020-06-14-00.00.00";
        DateTime dateTime = DateTime.of(validDate);
        assertNotNull(dateTime);
        assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                dateTime.getValue());
    }

    @Test
    void throwExceptionWhenLocalDateTimeIsNull() {
        assertThrows(DateTimeCannotBeNullException.class, () -> DateTime.of((LocalDateTime) null));
    }

    @Test
    void throwExceptionWhenLocalStringIsNull() {
        assertThrows(DateTimeCannotBeNullException.class, () -> DateTime.of((String) null));
    }

    @Test
    void throwExceptionWhenStringIsEmpty() {
        assertThrows(DateTimeCannotBeNullException.class, () -> DateTime.of(" "));
    }

    @Test
    void throwExceptionWhenInvalidDateFormat() {
        assertThrows(DateTimeInvalidValueException.class, () -> DateTime.of("2020/06/14 00:00:00"));
    }
}
