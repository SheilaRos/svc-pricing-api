package com.inditex.pricing.unit.domain.entity;

import com.inditex.pricing.domain.entity.Brand;
import com.inditex.pricing.domain.exception.BrandNameCannotBeNullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {

    @Test
    void createBrandWithValidIdAndNameSuccessfully() {
        Brand brand = Brand.builder()
                .withId(1L)
                .withName("ZARA")
                .build();

        assertNotNull(brand);
        assertEquals(1L, brand.getId());
        assertEquals("ZARA", brand.getName());
    }

    @Test
    void throwExceptionWhenNameIsNull() {
        Brand.Builder builder = Brand.builder().withId(1L);
        assertThrows(BrandNameCannotBeNullException.class, builder::build);
    }

    @Test
    void throwExceptionWhenNameIsEmpty() {
        Brand.Builder builder = Brand.builder()
                .withId(1L)
                .withName(" ");
        assertThrows(BrandNameCannotBeNullException.class, builder::build);
    }
}
