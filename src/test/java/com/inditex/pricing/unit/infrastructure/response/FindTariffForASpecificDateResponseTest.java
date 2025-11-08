package com.inditex.pricing.unit.infrastructure.response;

import com.inditex.pricing.application.dto.FindTariffForASpecificDateResult;
import com.inditex.pricing.infrastructure.userinterface.response.FindTariffForASpecificDateResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FindTariffForASpecificDateResponseTest {

    @Test
    void createFromPrimitivesConstructor() {
        long id = 999L;
        long brandId = 1L;
        long productId = 35455L;
        BigDecimal price = BigDecimal.valueOf(35.50);
        String currency = "EUR";
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59);

        FindTariffForASpecificDateResponse response =
                new FindTariffForASpecificDateResponse(id, brandId, productId, price, currency, startDate, endDate);

        assertNotNull(response);
        assertEquals(id, response.id());
        assertEquals(brandId, response.brandId());
        assertEquals(productId, response.productId());
        assertEquals(price, response.price());
        assertEquals(currency, response.currency());
        assertEquals(startDate, response.startDate());
        assertEquals(endDate, response.endDate());
    }

    @Test
    void shouldCreateFromResultConstructor() {
        FindTariffForASpecificDateResult result =
                new FindTariffForASpecificDateResult(
                        999L,
                        1L,
                        35455L,
                        BigDecimal.valueOf(35.50),
                        "EUR",
                        LocalDateTime.of(2020, 6, 14, 0, 0),
                        LocalDateTime.of(2020, 12, 31, 23, 59)
                );

        FindTariffForASpecificDateResponse response = new FindTariffForASpecificDateResponse(result);

        assertNotNull(response);
        assertEquals(result.id(), response.id());
        assertEquals(result.brandId(), response.brandId());
        assertEquals(result.productId(), response.productId());
        assertEquals(result.price(), response.price());
        assertEquals(result.currency(), response.currency());
        assertEquals(result.startDate(), response.startDate());
        assertEquals(result.endDate(), response.endDate());
    }
}
