package com.inditex.pricing.unit.domain.entity;

import com.inditex.pricing.domain.entity.Brand;
import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.valueobject.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TariffTest {

    @Test
    void createTariffWithAllFieldsSuccessfully() {
        TariffId tariffId = TariffId.of(1L);
        Amount amount = Amount.of(new BigDecimal("35.50"));
        Currency currency = Currency.EUR;
        Price price = Price.of(amount, currency);
        Brand brand = Brand.builder().withId(BrandId.of(1L))
                .withName(BrandName.of("ZARA")).build();
        ProductId productId = ProductId.of(35455L);
        Priority priority = Priority.of(0);
        DateTime start = DateTime.of("2020-06-14-00.00.00");
        DateTime end = DateTime.of("2020-12-31-23.59.59");

        Tariff tariff = Tariff.builder()
                .withTariffId(tariffId)
                .withPrice(price)
                .withBrand(brand)
                .withProductId(productId)
                .withPriority(priority)
                .withStartDate(start)
                .withEndDate(end)
                .build();

        assertNotNull(tariff);
        assertEquals(tariffId, tariff.getId());
        assertEquals(price, tariff.getPrice());
        assertEquals(brand, tariff.getBrand());
        assertEquals(productId, tariff.getProductId());
        assertEquals(priority, tariff.getPriority());
        assertEquals(start, tariff.getStartDate());
        assertEquals(end, tariff.getEndDate());
    }
}
