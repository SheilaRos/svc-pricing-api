package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.valueobject.BrandId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandIdTest {

    @Test
    void createBrandIdSuccessfully() {
        long expectedValue = 5L;
        BrandId brandId = BrandId.of(expectedValue);
        assertNotNull(brandId);
        assertEquals(expectedValue, brandId.getValue());
    }

    @Test
    void checkNotEquals() {
        BrandId id1 = BrandId.of(1L);
        BrandId id2 = BrandId.of(2L);
        assertNotEquals(id1.getValue(), id2.getValue());
    }

    @Test
    void checkEquals() {
        BrandId id1 = BrandId.of(10L);
        BrandId id2 = BrandId.of(10L);
        assertEquals(id1.getValue(), id2.getValue());
        assertNotSame(id1, id2);
    }
}