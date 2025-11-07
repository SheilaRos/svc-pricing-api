package com.inditex.pricing.infrastructure.repository.mapper;

import com.inditex.pricing.domain.entity.Brand;
import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.valueobject.*;
import com.inditex.pricing.infrastructure.repository.entity.PriceProjection;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public final class PriceEntityMapper {

    public Tariff mapToDomainObjectFromProjection(PriceProjection priceProjection) {
        return Tariff.builder()
                .withTariffId(TariffId.of(priceProjection.id()))
                .withBrand(mapBrandFromTariffProjection(priceProjection))
                .withProductId(ProductId.of(priceProjection.productId()))
                .withPrice(mapPrice(priceProjection.price(), priceProjection.currency()))
                .withPriority(Priority.of(priceProjection.priority()))
                .withStartDate(DateTime.of(priceProjection.startDate()))
                .withEndDate(DateTime.of(priceProjection.endDate()))
                .build();
    }

    private Brand mapBrandFromTariffProjection(PriceProjection priceProjection) {
        return Brand.builder()
                .withId(BrandId.of(priceProjection.brandId()))
                .withName(BrandName.of(priceProjection.brandName()))
                .build();
    }

    private Price mapPrice(BigDecimal amount, String currency) {
        Amount amt = Amount.of(amount);
        Currency curr = Currency.of(currency);

        return Price.of(amt, curr);
    }
}
