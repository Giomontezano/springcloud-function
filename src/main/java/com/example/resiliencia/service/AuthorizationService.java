package com.example.resiliencia.service;

import com.example.resiliencia.model.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorizationService {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationService.class);
    private List<Authorization> authorizations = new ArrayList<>();

    public List<Authorization> findAllTest() {
        LOG.info("Criando massa..");
        var massa = UUID.randomUUID();
        LOG.info("Masssa: "+ massa.toString());

        LOG.info("Inserindo massa..");
        create(massa);

        LOG.info("Buscando massa..");
        var values = findAll();

        LOG.info("Function findAll() -> Tamanho da massa: " + values.size());
        return values;
    }

    public List<Authorization> findAll() {
        LOG.info("FindAll Requested.");
        return authorizations;
    }

    public void create(UUID clearingId) {
        LOG.info("Authorization requested: " + clearingId.toString());
        authorizations.add(new Authorization(clearingId, false));
    }

}
