package com.inditex.pricing.infrastructure.repository.mapper;

import com.inditex.pricing.domain.entity.Brand;
import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.valueobject.*;
import com.inditex.pricing.infrastructure.repository.entity.BrandEntity;
import com.inditex.pricing.infrastructure.repository.entity.PriceEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public final class PriceEntityMapper {

    public Tariff mapToDomainObjectFromProjection(PriceEntity priceEntity) {
        return Tariff.builder()
                .withTariffId(TariffId.of(priceEntity.getId()))
                .withBrand(mapBrand(priceEntity.getBrand()))
                .withProductId(ProductId.of(priceEntity.getProductId()))
                .withPrice(mapPrice(priceEntity.getPrice(), priceEntity.getCurrency()))
                .withPriority(Priority.of(priceEntity.getPriority()))
                .withStartDate(DateTime.of(priceEntity.getStartDate()))
                .withEndDate(DateTime.of(priceEntity.getEndDate()))
                .build();
    }

    private Brand mapBrand(BrandEntity brandEntity) {
        return Brand.builder()
                .withId(BrandId.of(brandEntity.getId()))
                .withName(BrandName.of(brandEntity.getName()))
                .build();
    }

    private Price mapPrice(BigDecimal amount, String currency) {
        Amount amt = Amount.of(amount);
        Currency curr = Currency.of(currency);

        return Price.of(amt, curr);
    }
}
