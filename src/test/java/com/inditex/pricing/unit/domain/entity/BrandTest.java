package com.inditex.pricing.unit.domain.entity;

import com.inditex.pricing.domain.entity.Brand;
import com.inditex.pricing.domain.exception.BrandNameCannotBeNullException;
import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.BrandName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {

    @Test
    void createBrandWithValidIdAndNameSuccessfully() {
        Brand brand = Brand.builder()
                .withId(BrandId.of(1L))
                .withName(BrandName.of("ZARA"))
                .build();

        assertNotNull(brand);
        assertEquals(1L, brand.getId().getValue());
        assertEquals("ZARA", brand.getName().getValue());
    }
}
