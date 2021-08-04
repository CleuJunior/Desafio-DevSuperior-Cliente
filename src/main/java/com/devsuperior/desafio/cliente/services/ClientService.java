package com.devsuperior.desafio.cliente.services;

import com.devsuperior.desafio.cliente.entities.Client;
import com.devsuperior.desafio.cliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }
}
