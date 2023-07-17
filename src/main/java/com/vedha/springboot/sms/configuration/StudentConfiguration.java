package com.vedha.springboot.sms.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {

    @Bean
    public ModelMapper getModelMapper() {

        return new ModelMapper();
    }
}
