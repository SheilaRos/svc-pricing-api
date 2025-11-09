package com.inditex.pricing.unit.infrastructure.controller;

import com.inditex.pricing.application.dto.FindTariffForASpecificDateQuery;
import com.inditex.pricing.application.dto.FindTariffForASpecificDateResult;
import com.inditex.pricing.application.useCase.FindTariffForASpecificDateUseCase;
import com.inditex.pricing.infrastructure.userinterface.controller.FindTariffForASpecificDateController;
import com.inditex.pricing.infrastructure.userinterface.mapper.FindTariffForASpecificDateResponseMapper;
import com.inditex.pricing.infrastructure.userinterface.response.FindTariffForASpecificDateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindTariffForASpecificDateControllerTest {

    private FindTariffForASpecificDateUseCase useCase;
    private FindTariffForASpecificDateResponseMapper responseMapper;
    private FindTariffForASpecificDateController controller;

    @BeforeEach
    void setUp() {
        useCase = mock(FindTariffForASpecificDateUseCase.class);
        responseMapper = mock(FindTariffForASpecificDateResponseMapper.class);

        controller = new FindTariffForASpecificDateController(responseMapper, useCase);
    }

    @Test
    void requestSuccessfully() {
        long brandId = 1L;
        long productId = 1L;
        LocalDateTime date = LocalDateTime.now();

        FindTariffForASpecificDateResult result = new FindTariffForASpecificDateResult(1L, 1L, 35455L,
                BigDecimal.valueOf(35.50), "EUR", date, date);
        FindTariffForASpecificDateResponse responseExpected = new FindTariffForASpecificDateResponse(1L, 1L, 35455L,
                BigDecimal.valueOf(35.50), "EUR", date, date);


        when(useCase.get(any(FindTariffForASpecificDateQuery.class))).thenReturn(result);
        when(responseMapper.map(result)).thenReturn(responseExpected);
        ResponseEntity<FindTariffForASpecificDateResponse> response = controller.findTariffForDate(brandId, productId,
                date);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(responseExpected, response.getBody());
    }
}
