package com.inditex.pricing.utils;

import com.inditex.pricing.domain.entity.Brand;
import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.valueobject.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class TariffMotherObject {

    public static Tariff generate() {
        Brand brand = Brand.builder()
                .withId(BrandId.of(1L))
                .withName(BrandName.of("ZARA"))
                .build();

        TariffId tariffId = TariffId.of(1L);
        ProductId productId = ProductId.of(35455L);
        Price price = Price.of(Amount.of(BigDecimal.valueOf(35.50)), Currency.of("EUR"));
        DateTime startDate = DateTime.of(LocalDateTime.of(2020, 6, 14, 0, 0));
        DateTime endDate = DateTime.of(LocalDateTime.of(2020, 12, 31, 23, 59));

        return Tariff.builder()
                .withTariffId(tariffId)
                .withBrand(brand)
                .withProductId(productId)
                .withPrice(price)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .build();
    }
}
