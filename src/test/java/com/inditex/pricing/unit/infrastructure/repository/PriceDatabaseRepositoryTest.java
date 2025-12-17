package com.inditex.pricing.unit.infrastructure.repository;

import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.DateTime;
import com.inditex.pricing.domain.valueobject.ProductId;
import com.inditex.pricing.infrastructure.repository.PriceDatabaseRepository;
import com.inditex.pricing.infrastructure.repository.entity.PriceEntity;
import com.inditex.pricing.infrastructure.repository.jdbc.PriceJpaRepository;
import com.inditex.pricing.infrastructure.repository.mapper.PriceEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PriceDatabaseRepositoryTest {
    private PriceEntityMapper mapper;
    private PriceJpaRepository jps;
    private PriceDatabaseRepository repository;

    @BeforeEach
    void setUp() {
        mapper = mock(PriceEntityMapper.class);
        jps = mock(PriceJpaRepository.class);

        repository = new PriceDatabaseRepository(jps, mapper);
    }

    @Test
    void getTariffSuccessfully() {
        Tariff tariffExpected = mock(Tariff.class);
        PriceEntity priceEntity = mock(PriceEntity.class);

        DateTime date = DateTime.of(LocalDateTime.now());
        BrandId brandId = BrandId.of(1L);
        ProductId productId = ProductId.of(35455L);

        when(jps.findByBrandIdProductIdAndDate(brandId.getValue(), productId.getValue(), date.getValue()))
                .thenReturn(List.of(priceEntity));
        when(mapper.mapToDomainObjectFromProjection(priceEntity)).thenReturn(tariffExpected);

        Optional<Tariff> tariff = repository.findTariffsApplicable(date, brandId, productId);

        assertTrue(tariff.isPresent());
        assertEquals(tariffExpected, tariff.get());

        InOrder order = inOrder(mapper, jps);
        order.verify(jps, times(1)).findByBrandIdProductIdAndDate(brandId.getValue(),
                productId.getValue(), date.getValue());
        order.verify(mapper, times(1)).mapToDomainObjectFromProjection(priceEntity);
    }

    @Test
    void getTariffEmpty() {
        DateTime date = DateTime.of(LocalDateTime.now());
        BrandId brandId = BrandId.of(1L);
        ProductId productId = ProductId.of(35455L);

        when(jps.findByBrandIdProductIdAndDate(brandId.getValue(), productId.getValue(), date.getValue()))
                .thenReturn(List.of());

        Optional<Tariff> tariff = repository.findTariffsApplicable(date, brandId, productId);

        assertFalse(tariff.isPresent());

        InOrder order = inOrder(mapper, jps);
        order.verify(jps, times(1)).findByBrandIdProductIdAndDate(brandId.getValue(),
                productId.getValue(), date.getValue());
        verifyNoInteractions(mapper);
    }
}
