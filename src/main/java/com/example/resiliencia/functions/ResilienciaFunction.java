package com.example.resiliencia.functions;

import com.example.resiliencia.model.Authorization;
import com.example.resiliencia.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class ResilienciaFunction {

    private final AuthorizationService authorizationService;

    public ResilienciaFunction(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Bean
    public Supplier<List<Authorization>> findAll() {
        return () -> authorizationService.findAll();
    }

    @Bean
    public Consumer<UUID> create() {
        return (clearingId) -> authorizationService.create(clearingId);
    }
}
