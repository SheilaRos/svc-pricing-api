package com.inditex.pricing.application.dto;

import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.utils.TariffMotherObject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FindTariffForASpecificDateResultTest {

    @Test
    void createByTariffSuccessfully() {
        Tariff tariff = TariffMotherObject.generate();

        FindTariffForASpecificDateResult result = new FindTariffForASpecificDateResult(tariff);

        assertNotNull(result);
        assertEquals(tariff.getId().getValue(), result.id());
        assertEquals(tariff.getBrand().getId().getValue(), result.brandId());
        assertEquals(tariff.getProductId().getValue(), result.productId());
        assertEquals(tariff.getPrice().getAmount().getValue(), result.price());
        assertEquals(tariff.getPrice().getCurrency().getValue(), result.currency());
        assertEquals(tariff.getStartDate().getValue(), result.startDate());
        assertEquals(tariff.getEndDate().getValue(), result.endDate());
    }


    @Test
    void createWithRawValuesSuccessfully() {
        FindTariffForASpecificDateResult result =
                new FindTariffForASpecificDateResult(1L, 1L, 35455L,
                        BigDecimal.valueOf(35.50), "EUR",
                        LocalDateTime.of(2020, 6, 14, 0, 0),
                        LocalDateTime.of(2020, 12, 31, 23, 59));

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals(1L, result.brandId());
        assertEquals(35455L, result.productId());
        assertEquals(BigDecimal.valueOf(35.50), result.price());
        assertEquals("EUR", result.currency());
        assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0), result.startDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59), result.endDate());

    }
}
