package com.inditex.pricing.infrastructure.repository.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Table(name = "BRAND")
public record BrandEntity(
        @Id
        long id,
        String name
) {
}
