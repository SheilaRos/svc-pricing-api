package com.inditex.pricing.infrastructure.userinterface.controller;

import com.inditex.pricing.application.dto.FindTariffForASpecificDateQuery;
import com.inditex.pricing.application.dto.FindTariffForASpecificDateResult;
import com.inditex.pricing.application.useCase.FindTariffForASpecificDateUseCase;
import com.inditex.pricing.infrastructure.userinterface.mapper.FindTariffForASpecificDateResponseMapper;
import com.inditex.pricing.infrastructure.userinterface.response.FindTariffForASpecificDateResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
@AllArgsConstructor
public class FindTariffForASpecificDateController {
    private final FindTariffForASpecificDateResponseMapper responseMapper;
    private final FindTariffForASpecificDateUseCase useCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "success", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<FindTariffForASpecificDateResponse> findTariffForDate(@RequestParam long brandId, @RequestParam long productId,
                                              @RequestParam LocalDateTime date) {

        FindTariffForASpecificDateQuery query = new FindTariffForASpecificDateQuery(brandId, productId, date);
        FindTariffForASpecificDateResult result = useCase.get(query);

        return ResponseEntity.ok(this.responseMapper.map(result));
    }
}
