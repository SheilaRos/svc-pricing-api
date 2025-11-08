package com.inditex.pricing.unit.infrastructure.response;

import com.inditex.pricing.infrastructure.userinterface.response.ErrorResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {

    @Test
    void createErrorResponseSuccessfully() {
        ErrorResponse err = new ErrorResponse("error", "test");

        assertEquals("error", err.status());
        assertEquals("test", err.message());
    }
}
