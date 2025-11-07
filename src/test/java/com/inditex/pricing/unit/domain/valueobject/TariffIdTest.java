package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.valueobject.TariffId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TariffIdTest {

    @Test
    void createTariffIdSuccessfully() {
        long expectedValue = 5L;
        TariffId tariffId = TariffId.of(expectedValue);
        assertNotNull(tariffId);
        assertEquals(expectedValue, tariffId.getValue());
    }

    @Test
    void checkNotEquals() {
        TariffId id1 = TariffId.of(1L);
        TariffId id2 = TariffId.of(2L);
        assertNotEquals(id1.getValue(), id2.getValue());
    }

    @Test
    void checkEquals() {
        TariffId id1 = TariffId.of(10L);
        TariffId id2 = TariffId.of(10L);
        assertEquals(id1.getValue(), id2.getValue());
        assertNotSame(id1, id2);
    }
}