package com.inditex.pricing.unit.application.dto;

import com.inditex.pricing.application.dto.FindTariffForASpecificDateQuery;
import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.DateTime;
import com.inditex.pricing.domain.valueobject.ProductId;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FindTariffForASpecificDateQueryTest {

    @Test
    void createFromPrimitivesConstructorSuccessfully() {
        long brandId = 1L;
        long productId = 35455L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

        FindTariffForASpecificDateQuery query = new FindTariffForASpecificDateQuery(brandId, productId, date);

        assertNotNull(query);
        assertEquals(brandId, query.brandId().getValue());
        assertEquals(productId, query.productId().getValue());
        assertEquals(date, query.date().getValue());
    }

    @Test
    void createFromValueObjectsConstructorSuccessfully() {
        BrandId brandId = BrandId.of(1L);
        ProductId productId = ProductId.of(35455L);
        DateTime date = DateTime.of(LocalDateTime.of(2020, 6, 14, 10, 0));

        FindTariffForASpecificDateQuery query = new FindTariffForASpecificDateQuery(brandId, productId, date);

        assertNotNull(query);
        assertEquals(brandId, query.brandId());
        assertEquals(productId, query.productId());
        assertEquals(date, query.date());
    }
}