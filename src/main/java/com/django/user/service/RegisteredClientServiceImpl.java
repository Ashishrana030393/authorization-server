package com.django.user.service;

import com.django.user.dao.ClientRepository;
import com.django.user.entity.Client;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

public class RegisteredClientServiceImpl implements RegisteredClientRepository {
    private final ClientRepository clientRepository;

    public RegisteredClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(RegisteredClient registeredClient) {
        //TODO
    }

    @Override
    public RegisteredClient findById(String id) {
        Client byId = this.clientRepository.findById(Long.parseLong(id));
        return Client.fromClient(byId);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Client client = this.clientRepository.findByClientId(clientId);
        return Client.fromClient(client);
    }
}
