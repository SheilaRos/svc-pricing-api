package com.inditex.pricing.infrastructure.userinterface.mapper;

import com.inditex.pricing.application.dto.FindTariffForASpecificDateResult;
import com.inditex.pricing.infrastructure.userinterface.response.FindTariffForASpecificDateResponse;

public class FindTariffForASpecificDateResponseMapper {

    public FindTariffForASpecificDateResponse map(FindTariffForASpecificDateResult result) {
        return new FindTariffForASpecificDateResponse(result.id(),
                result.brandId(),
                result.productId(),
                result.price(),
                result.currency(),
                result.startDate(),
                result.endDate());
    }
}
