package com.example.bookingapiauth.config;

import com.example.bookingapiauth.datastorage.DataStorageImpl;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class Config {

    @Bean
    @Lazy
    public DataStorageImpl dataStorage() {
        return new DataStorageImpl();
    }

    @Bean
    @Lazy
    public Faker faker() {
        return new Faker();
    }

}
