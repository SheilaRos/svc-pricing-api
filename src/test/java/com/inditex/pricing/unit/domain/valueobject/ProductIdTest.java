package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.valueobject.ProductId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductIdTest {

    @Test
    void createProductIdSuccessfully() {
        long expectedValue = 5L;
        ProductId productId = ProductId.of(expectedValue);
        assertNotNull(productId);
        assertEquals(expectedValue, productId.getValue());
    }

    @Test
    void checkNotEquals() {
        ProductId id1 = ProductId.of(1L);
        ProductId id2 = ProductId.of(2L);
        assertNotEquals(id1.getValue(), id2.getValue());
    }

    @Test
    void checkEquals() {
        ProductId id1 = ProductId.of(10L);
        ProductId id2 = ProductId.of(10L);
        assertEquals(id1.getValue(), id2.getValue());
        assertNotSame(id1, id2);
    }
}