package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.valueobject.Priority;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityTest {

    @Test
    void createPrioritySuccessfully() {
        long expectedValue = 1L;
        Priority priority = Priority.of(expectedValue);
        assertNotNull(priority);
        assertEquals(expectedValue, priority.getValue());
    }

    @Test
    void checkNotEquals() {
        Priority p1 = Priority.of(1L);
        Priority p2 = Priority.of(2L);
        assertNotEquals(p1.getValue(), p2.getValue());
    }

    @Test
    void checkEquals() {
        Priority p1 = Priority.of(5L);
        Priority p2 = Priority.of(5L);
        assertEquals(p1.getValue(), p2.getValue());
        assertNotSame(p1, p2);
    }
}
