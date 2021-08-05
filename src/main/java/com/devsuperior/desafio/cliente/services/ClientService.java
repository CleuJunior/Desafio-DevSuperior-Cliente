package com.devsuperior.desafio.cliente.services;

import com.devsuperior.desafio.cliente.entities.Client;
import com.devsuperior.desafio.cliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.Instant;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Long id){
        try{
            return repository.findById(id).orElseThrow();
        } catch(Exception e)
        {
            return null;
        }

    }

    public Client insert(Client client){

        return new Client();
//        return new Client("Teste nome teste", "12345678900", 9999.89, Instant.now(), 4);

    }
}
