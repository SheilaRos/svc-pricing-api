package com.inditex.pricing.application.useCase;

import com.inditex.pricing.application.exception.TariffNotFoundException;
import com.inditex.pricing.application.dto.FindTariffForASpecificDateQuery;
import com.inditex.pricing.application.dto.FindTariffForASpecificDateResult;
import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.repository.TariffRepository;

import java.util.Optional;

public final class FindTariffForASpecificDateUseCase {
    private final TariffRepository repository;

    public FindTariffForASpecificDateUseCase(TariffRepository repository) {
        this.repository = repository;
    }

    public FindTariffForASpecificDateResult get(FindTariffForASpecificDateQuery query) {
        Optional<Tariff> tariff = this.repository.findTariffsApplicable(query.date(), query.brandId(),
                query.productId());

        if (tariff.isEmpty()) {
            throw new TariffNotFoundException();
        }

        return new FindTariffForASpecificDateResult(tariff.get());
    }
}
