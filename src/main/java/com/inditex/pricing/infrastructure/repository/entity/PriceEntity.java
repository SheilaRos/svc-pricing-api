package com.inditex.pricing.infrastructure.repository.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Table(name = "PRICE")
public record PriceEntity(
        @Id
        long id,
        long brandId,
        long productId,
        int priority,
        BigDecimal price,
        String currency,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
