package com.inditex.pricing.application.dto;

import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.DateTime;
import com.inditex.pricing.domain.valueobject.ProductId;

import java.time.LocalDateTime;

public record FindTariffForASpecificDateQuery (BrandId brandId, ProductId productId, DateTime date){

    public FindTariffForASpecificDateQuery(long brandId, long productId, LocalDateTime date) {
        this(BrandId.of(brandId), ProductId.of(productId), DateTime.of(date));
    }
}
