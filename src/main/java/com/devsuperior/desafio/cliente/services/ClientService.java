package com.devsuperior.desafio.cliente.services;

import com.devsuperior.desafio.cliente.entities.Client;
import com.devsuperior.desafio.cliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
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
       return repository.save(client);

    }

    public Client update(Long id, Client client) {

        try {
            Client entity = repository.getOne(id);
            entity.setName(client.getName());
            entity.setCpf(client.getCpf());
            entity.setIncome(client.getIncome());
            entity.setBirthDate(client.getBirthDate());
            entity.setChildren(client.getChildren());
            repository.save(entity);
            return entity;

        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException();

        }

    }


    public void delete(Long id){
        repository.deleteById(id);

    }
}
