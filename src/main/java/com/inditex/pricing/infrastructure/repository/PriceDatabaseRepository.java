package com.inditex.pricing.infrastructure.repository;

import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.repository.TariffRepository;
import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.DateTime;
import com.inditex.pricing.domain.valueobject.ProductId;
import com.inditex.pricing.infrastructure.repository.entity.PriceEntity;
import com.inditex.pricing.infrastructure.repository.jdbc.PriceJpaRepository;
import com.inditex.pricing.infrastructure.repository.mapper.PriceEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PriceDatabaseRepository implements TariffRepository {

    private final PriceJpaRepository repository;
    private final PriceEntityMapper mapper;

    public PriceDatabaseRepository(PriceJpaRepository repository, PriceEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Tariff> findTariffsApplicable(DateTime dateTime, BrandId brandId, ProductId productId) {
        Optional<PriceEntity> price = this.repository.findByBrandIdProductIdAndDate(brandId.getValue(),
                productId.getValue(), dateTime.getValue()).stream().findFirst();

        if (price.isEmpty()) {
            return Optional.empty();
        }

        return price.map(mapper::mapToDomainObjectFromProjection);
    }
}
