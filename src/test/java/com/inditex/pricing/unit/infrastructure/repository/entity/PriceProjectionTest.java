package com.inditex.pricing.unit.infrastructure.repository.entity;

import com.inditex.pricing.infrastructure.repository.entity.PriceProjection;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceProjectionTest {

    @Test
    void createPriceProjectionSuccessfully() {
        LocalDateTime start = LocalDateTime.of(2020, 6, 14, 0, 0);
        LocalDateTime end = LocalDateTime.of(2020, 12, 31, 23, 59);

        PriceProjection price = PriceProjection.builder()
                .id(1L)
                .brandId(2L)
                .productId(35455L)
                .priority(1)
                .price(new BigDecimal("35.50"))
                .currency("EUR")
                .startDate(start)
                .endDate(end)
                .brandName("ZARA")
                .build();

        assertEquals(1L, price.id());
        assertEquals(2L, price.brandId());
        assertEquals(35455L, price.productId());
        assertEquals(1, price.priority());
        assertEquals(new BigDecimal("35.50"), price.price());
        assertEquals("EUR", price.currency());
        assertEquals(start, price.startDate());
        assertEquals(end, price.endDate());
        assertEquals("ZARA", price.brandName());
    }
}
