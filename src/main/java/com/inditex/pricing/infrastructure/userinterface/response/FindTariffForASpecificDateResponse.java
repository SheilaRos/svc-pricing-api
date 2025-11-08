package com.inditex.pricing.infrastructure.userinterface.response;

import com.inditex.pricing.application.dto.FindTariffForASpecificDateResult;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FindTariffForASpecificDateResponse(long id, long brandId, long productId, BigDecimal price,
                                                 String currency, LocalDateTime startDate, LocalDateTime endDate) {

    public FindTariffForASpecificDateResponse(FindTariffForASpecificDateResult tariff) {
        this(
                tariff.id(),
                tariff.brandId(),
                tariff.productId(),
                tariff.price(),
                tariff.currency(),
                tariff.startDate(),
                tariff.endDate()
        );
    }
}
