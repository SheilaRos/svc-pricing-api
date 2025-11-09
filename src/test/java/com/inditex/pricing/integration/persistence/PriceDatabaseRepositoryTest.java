package com.inditex.pricing.integration.persistence;

import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.repository.TariffRepository;
import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.DateTime;
import com.inditex.pricing.domain.valueobject.ProductId;
import com.inditex.pricing.infrastructure.repository.jdbc.PriceJdbcRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = {"classpath:application-test.properties", "classpath:application-test.yml"})
class PriceDatabaseRepositoryTest {

    @Autowired
    private PriceJdbcRepository jdbcRepository;

    @Autowired
    private TariffRepository repository;

    @Test
    void findTariffSuccessfully() {
        BrandId brandId = BrandId.of(1L);
        ProductId productId = ProductId.of(35455L);
        DateTime date = DateTime.of("2020-06-14-00.00.00");

        Optional<Tariff> tariff = repository.findTariffsApplicable(date, brandId, productId);

        assertTrue(tariff.isPresent());
        assertEquals(1L, tariff.get().getId().getValue());
        assertEquals(1L, tariff.get().getBrand().getId().getValue());
        assertEquals("ZARA", tariff.get().getBrand().getName().getValue());
        assertEquals(35455, tariff.get().getProductId().getValue());
        assertEquals(0, tariff.get().getPriority().getValue());
        assertEquals(new BigDecimal("35.50"), tariff.get().getPrice().getAmount().getValue());
        assertEquals("EUR", tariff.get().getPrice().getCurrency().getValue());
        assertEquals(DateTime.of("2020-06-14-00.00.00").getValue(), tariff.get().getStartDate().getValue());
        assertEquals(DateTime.of("2020-12-31-23.59.59").getValue(), tariff.get().getEndDate().getValue());
    }

    @Test
    void tariffNotFound() {
        BrandId brandId = BrandId.of(2L);
        ProductId productId = ProductId.of(35455L);
        DateTime date = DateTime.of("2020-06-14-00.00.00");

        Optional<Tariff> tariff = repository.findTariffsApplicable(date, brandId, productId);

        assertTrue(tariff.isEmpty());
    }
}
