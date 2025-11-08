package com.inditex.pricing.application.dto;

import com.inditex.pricing.domain.entity.Tariff;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FindTariffForASpecificDateResult(long id, long brandId, long productId, BigDecimal price,
                                               String currency, LocalDateTime startDate, LocalDateTime endDate) {

    public FindTariffForASpecificDateResult(Tariff tariff) {
        this(
                tariff.getId().getValue(),
                tariff.getBrand().getId().getValue(),
                tariff.getProductId().getValue(),
                tariff.getPrice().getAmount().getValue(),
                tariff.getPrice().getCurrency().getValue(),
                tariff.getStartDate().getValue(),
                tariff.getEndDate().getValue()
        );
    }
}
