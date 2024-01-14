package com.django.user.dao;


import com.django.user.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findAll();
    Client findById(long id);

    Client findByClientId(String clientId);
}
