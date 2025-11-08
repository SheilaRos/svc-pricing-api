package com.inditex.pricing.infrastructure.config;

import com.inditex.pricing.application.useCase.FindTariffForASpecificDateUseCase;
import com.inditex.pricing.domain.repository.TariffRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public FindTariffForASpecificDateUseCase findTariffForASpecificDateUseCase(TariffRepository repository) {
        return new FindTariffForASpecificDateUseCase(repository);
    }
}
