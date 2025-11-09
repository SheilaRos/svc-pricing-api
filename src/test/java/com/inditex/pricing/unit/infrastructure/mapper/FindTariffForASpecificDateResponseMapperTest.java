package com.inditex.pricing.unit.infrastructure.mapper;

import com.inditex.pricing.application.dto.FindTariffForASpecificDateResult;
import com.inditex.pricing.infrastructure.userinterface.mapper.FindTariffForASpecificDateResponseMapper;
import com.inditex.pricing.infrastructure.userinterface.response.FindTariffForASpecificDateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FindTariffForASpecificDateResponseMapperTest {

    private FindTariffForASpecificDateResponseMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new FindTariffForASpecificDateResponseMapper();
    }

    @Test
    void mapSuccessfully() {
        FindTariffForASpecificDateResult result =
                new FindTariffForASpecificDateResult(1L, 1L, 35455L,
                        BigDecimal.valueOf(35.50), "EUR",
                        LocalDateTime.of(2020, 6, 14, 0, 0),
                        LocalDateTime.of(2020, 12, 31, 23, 59));

        FindTariffForASpecificDateResponse response = mapper.map(result);

        assertNotNull(response);
        assertEquals(1L, response.id());
        assertEquals(1L, response.brandId());
        assertEquals(35455L, response.productId());
        assertEquals(BigDecimal.valueOf(35.50), response.price());
        assertEquals("EUR", response.currency());
        assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0), response.startDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59), response.endDate());
    }
}
