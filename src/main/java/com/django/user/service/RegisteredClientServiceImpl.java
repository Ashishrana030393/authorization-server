package com.django.user.service;

import com.django.user.dao.ClientRepository;
import com.django.user.entity.Client;
import com.django.user.entity.ClientTokenSettings;
import com.django.user.mapper.ClientMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RegisteredClientServiceImpl implements RegisteredClientRepository, RegisteredClientService {
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

    @Override
    public Integer uploadRegisteredClient(MultipartFile file) throws IOException {
        Set<Client> clients = parseCsv(file);
        this.clientRepository.saveAll(clients);
        return clients.size();
    }

    private Set<Client> parseCsv(MultipartFile file) throws IOException {
        try(BufferedReader br  = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            HeaderColumnNameMappingStrategy<ClientCSVRepresentation> strategy = new HeaderColumnNameMappingStrategy<ClientCSVRepresentation>();
            strategy.setType(ClientCSVRepresentation.class);
            CsvToBean<ClientCSVRepresentation> csvToBean  = new CsvToBeanBuilder(br)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.stream().map(csvLine-> {
                Client client = ClientMapper.INSTANCE.toClient(csvLine);
                client.setTokenSettings(new ClientTokenSettings(csvLine.getTtl(), csvLine.getType()));
                return client;
            }).collect(Collectors.toSet());
        }
    }
}
