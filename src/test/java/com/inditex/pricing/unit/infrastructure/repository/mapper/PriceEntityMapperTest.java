package com.inditex.pricing.unit.infrastructure.repository.mapper;

import com.inditex.pricing.domain.entity.Brand;
import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.valueobject.*;
import com.inditex.pricing.infrastructure.repository.entity.BrandEntity;
import com.inditex.pricing.infrastructure.repository.entity.PriceEntity;
import com.inditex.pricing.infrastructure.repository.mapper.PriceEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceEntityMapperTest {
    private PriceEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new PriceEntityMapper();
    }

    @Test
    void mapToDomainObjectFromProjectionSuccessfully() {
        LocalDateTime start = LocalDateTime.of(2020, 6, 14, 0, 0);
        LocalDateTime end = LocalDateTime.of(2020, 12, 31, 23, 59);

        PriceEntity projection = PriceEntity.builder()
                .id(1L)
                .brand(
                        BrandEntity.builder()
                                .id(2L)
                                .name("ZARA")
                                .build()
                )
                .productId(35455L)
                .priority(1)
                .price(new BigDecimal("35.50"))
                .currency("EUR")
                .startDate(start)
                .endDate(end)
                .build();

        Tariff tariff = mapper.mapToDomainObjectFromProjection(projection);

        assertEquals(1L, tariff.getId().getValue());
        assertEquals(35455L, tariff.getProductId().getValue());
        assertEquals(1, tariff.getPriority().getValue());
        assertEquals(start, tariff.getStartDate().getValue());
        assertEquals(end, tariff.getEndDate().getValue());

        Brand brand = tariff.getBrand();
        assertEquals(2L, brand.getId().getValue());
        assertEquals("ZARA", brand.getName().getValue());

        Price price = tariff.getPrice();
        assertEquals(new BigDecimal("35.50"), price.getAmount().getValue());
        assertEquals("EUR", price.getCurrency().getValue());
    }
}
