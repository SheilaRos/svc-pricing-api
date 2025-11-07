package com.inditex.pricing.unit.infrastructure.repository.entity;

import com.inditex.pricing.infrastructure.repository.entity.BrandEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandEntityTest {

    @Test
    void createBrandEntityWithAllValuesSuccessfully() {

        BrandEntity entity = BrandEntity.builder()
                .id(1L)
                .name("ZARA")
                .build();

        assertNotNull(entity);
        assertEquals(1L, entity.id());
        assertEquals("ZARA", entity.name());
    }
}
