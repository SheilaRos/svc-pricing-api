package com.inditex.pricing.infrastructure.repository.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record PriceProjection(
        @Id
        long id,
        long brandId,
        long productId,
        int priority,
        BigDecimal price,
        String currency,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String brandName
) {
}
