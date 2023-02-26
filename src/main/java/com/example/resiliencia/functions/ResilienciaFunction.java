package com.example.resiliencia.functions;

import com.example.resiliencia.model.Authorization;
import com.example.resiliencia.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class ResilienciaFunction {

    private static final Logger LOG = LoggerFactory.getLogger(ResilienciaFunction.class);

    @Autowired
    private AuthorizationService authorizationService;

    @Bean
    public Supplier<List<Authorization>> findAll() {
        LOG.info("Function findAllTest()");
        return () -> authorizationService.findAllTest();
    }

    @Bean
    public Consumer<UUID> create() {
        LOG.info("Function create()");
        return (clearingId) -> authorizationService.create(clearingId);
    }
}
