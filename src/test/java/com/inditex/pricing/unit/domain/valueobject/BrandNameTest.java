package com.inditex.pricing.unit.domain.valueobject;

import com.inditex.pricing.domain.exception.BrandNameCannotBeNullException;
import com.inditex.pricing.domain.valueobject.BrandName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandNameTest {

    @Test
    void createBrandNameSuccessfully() {
        BrandName brandName = BrandName.of("ZARA");
        assertNotNull(brandName);
        assertEquals("ZARA", brandName.getValue());
    }

    @Test
    void throwExceptionWhenNameIsNull() {
        assertThrows(BrandNameCannotBeNullException.class, () -> BrandName.of(null));
    }

    @Test
    void throwExceptionWhenNameIsEmpty() {
        assertThrows(BrandNameCannotBeNullException.class, () -> BrandName.of(" "));
    }
}
