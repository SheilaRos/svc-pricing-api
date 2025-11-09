package com.inditex.pricing.infrastructure.config;

import com.inditex.pricing.infrastructure.userinterface.mapper.FindTariffForASpecificDateResponseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public FindTariffForASpecificDateResponseMapper findTariffForASpecificDateResponseMapper() {
        return new FindTariffForASpecificDateResponseMapper();
    }
}
