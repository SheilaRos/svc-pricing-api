package com.inditex.pricing.infrastructure.userinterface.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FindTariffForASpecificDateResponse(long id, long brandId, long productId, BigDecimal price,
                                                 String currency, LocalDateTime startDate, LocalDateTime endDate) {
}
