package com.inditex.pricing.unit.infrastructure.repository;

import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.DateTime;
import com.inditex.pricing.domain.valueobject.ProductId;
import com.inditex.pricing.infrastructure.repository.PriceDatabaseRepository;
import com.inditex.pricing.infrastructure.repository.entity.PriceProjection;
import com.inditex.pricing.infrastructure.repository.jdbc.PriceJdbcRepository;
import com.inditex.pricing.infrastructure.repository.mapper.PriceEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PriceDatabaseRepositoryTest {
    private PriceEntityMapper mapper;
    private PriceJdbcRepository jdbc;
    private PriceDatabaseRepository repository;

    @BeforeEach
    void setUp() {
        mapper = mock(PriceEntityMapper.class);
        jdbc = mock(PriceJdbcRepository.class);

        repository = new PriceDatabaseRepository(jdbc, mapper);
    }

    @Test
    void getTariffSuccessfully() {
        Tariff tariffExpected = mock(Tariff.class);
        PriceProjection projection = mock(PriceProjection.class);

        DateTime date = DateTime.of(LocalDateTime.now());
        BrandId brandId = BrandId.of(1L);
        ProductId productId = ProductId.of(35455L);

        when(jdbc.findByBrandIdProductIdAndDate(brandId.getValue(), productId.getValue(), date.getValue()))
                .thenReturn(Optional.of(projection));
        when(mapper.mapToDomainObjectFromProjection(projection)).thenReturn(tariffExpected);

        Optional<Tariff> tariff = repository.findTariffsApplicable(date, brandId, productId);

        assertTrue(tariff.isPresent());
        assertEquals(tariffExpected, tariff.get());

        InOrder order = inOrder(mapper, jdbc);
        order.verify(jdbc, times(1)).findByBrandIdProductIdAndDate(brandId.getValue(),
                productId.getValue(), date.getValue());
        order.verify(mapper, times(1)).mapToDomainObjectFromProjection(projection);
    }

    @Test
    void getTariffEmpty() {
        DateTime date = DateTime.of(LocalDateTime.now());
        BrandId brandId = BrandId.of(1L);
        ProductId productId = ProductId.of(35455L);

        when(jdbc.findByBrandIdProductIdAndDate(brandId.getValue(), productId.getValue(), date.getValue()))
                .thenReturn(Optional.empty());

        Optional<Tariff> tariff = repository.findTariffsApplicable(date, brandId, productId);

        assertFalse(tariff.isPresent());

        InOrder order = inOrder(mapper, jdbc);
        order.verify(jdbc, times(1)).findByBrandIdProductIdAndDate(brandId.getValue(),
                productId.getValue(), date.getValue());
        verifyNoInteractions(mapper);
    }
}
