package com.inditex.pricing.unit.application.usecase;

import com.inditex.pricing.application.TariffNotFound;
import com.inditex.pricing.application.dto.FindTariffForASpecificDateQuery;
import com.inditex.pricing.application.dto.FindTariffForASpecificDateResult;
import com.inditex.pricing.application.useCase.FindTariffForASpecificDateUseCase;
import com.inditex.pricing.domain.entity.Tariff;
import com.inditex.pricing.domain.repository.TariffRepository;
import com.inditex.pricing.utils.TariffMotherObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FindTariffForASpecificDateUseCaseTest {
    private TariffRepository repository;
    private FindTariffForASpecificDateUseCase useCase;

    @BeforeEach
    void setUp() {
        repository = mock(TariffRepository.class);

        useCase = new FindTariffForASpecificDateUseCase(repository);
    }

    @Test
    void returnResultWhenTariffFound() {
        long brandId = 1L;
        long productId = 35455L;
        LocalDateTime when = LocalDateTime.of(2020, 6, 14, 10, 0);
        FindTariffForASpecificDateQuery query =
                new FindTariffForASpecificDateQuery(brandId, productId, when);

        Tariff tariff = TariffMotherObject.generate();

        when(repository.findTariffsApplicable(query.date(), query.brandId(), query.productId()))
                .thenReturn(Optional.of(tariff));
        FindTariffForASpecificDateResult result = useCase.get(query);

        assertNotNull(result);
        assertEquals(tariff.getId().getValue(), result.id());
        assertEquals(tariff.getBrand().getId().getValue(), result.brandId());
        assertEquals(tariff.getProductId().getValue(), result.productId());
        assertEquals(tariff.getPrice().getAmount().getValue(), result.price());
        assertEquals(tariff.getPrice().getCurrency().getValue(), result.currency());
        assertEquals(tariff.getStartDate().getValue(), result.startDate());
        assertEquals(tariff.getEndDate().getValue(), result.endDate());

        verify(repository, times(1))
                .findTariffsApplicable(query.date(), query.brandId(), query.productId());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void theowExceptionWhenNotFoundTariff() {
        FindTariffForASpecificDateQuery query =
                new FindTariffForASpecificDateQuery(1L, 35455L, LocalDateTime.of(2020, 6, 14, 21, 0));

        when(repository.findTariffsApplicable(query.date(), query.brandId(), query.productId()))
                .thenReturn(Optional.empty());

        assertThrows(TariffNotFound.class, () -> useCase.get(query));

        verify(repository, times(1))
                .findTariffsApplicable(query.date(), query.brandId(), query.productId());
        verifyNoMoreInteractions(repository);
    }
}
