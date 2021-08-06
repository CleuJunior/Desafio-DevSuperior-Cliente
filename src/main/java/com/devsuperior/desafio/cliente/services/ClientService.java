package com.devsuperior.desafio.cliente.services;

import com.devsuperior.desafio.cliente.dto.ClientDTO;
import com.devsuperior.desafio.cliente.entities.Client;
import com.devsuperior.desafio.cliente.repositories.ClientRepository;
import com.devsuperior.desafio.cliente.services.exceptions.DatabaseException;
import com.devsuperior.desafio.cliente.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest)
    {
        Page<Client> list = repository.findAll(pageRequest);
        return list.map(x -> new ClientDTO(x));

    }

    public List<Client> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Optional<Client> obj = repository.findById(id);
        Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO){
        Client entityClient = new Client();
        copyDtoToEntity(clientDTO, entityClient);
        entityClient = repository.save(entityClient);

        return new ClientDTO(entityClient);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {

        try {
            Client entity = repository.getOne(id);
            copyDtoToEntity(clientDTO, entity);
            entity = repository.save(entity);

            return new ClientDTO(entity);

        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }

    }

    @Transactional
    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found " + id);

        } catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }

    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client clientEntity) {
        clientEntity.setName(clientDTO.getName());
        clientEntity.setCpf(clientDTO.getCpf());
        clientEntity.setIncome(clientDTO.getIncome());
        clientEntity.setBirthDate(clientDTO.getBirthDate());
        clientEntity.setChildren(clientDTO.getChildren());

    }

}
