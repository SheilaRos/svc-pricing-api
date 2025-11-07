package com.inditex.pricing.domain.repository;

import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.DateTime;
import com.inditex.pricing.domain.valueobject.ProductId;
import java.util.Optional;

public interface TariffRepository {

    Optional<Tariff> findTariffsApplicable(DateTime dateTime, BrandId brandId, ProductId productId);
}
