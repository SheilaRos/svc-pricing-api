package com.inditex.pricing.unit.infrastructure.repository.entity;

import com.inditex.pricing.infrastructure.repository.entity.BrandEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandEntityTest {

    @Test
    void createBrandEntityWithAllValuesSuccessfully() {

        BrandEntity.BrandEntityBuilder builder = BrandEntity.builder()
                .id(1L)
                .name("ZARA");

        String builderStr = builder.toString();
        assertNotNull(builderStr);
        assertFalse(builderStr.isBlank());

        BrandEntity entity = builder.build();
        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("ZARA", entity.getName());
    }
}
