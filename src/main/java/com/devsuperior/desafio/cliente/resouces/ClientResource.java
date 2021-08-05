package com.devsuperior.desafio.cliente.resouces;

import com.devsuperior.desafio.cliente.entities.Client;
import com.devsuperior.desafio.cliente.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody Client client){
        client = service.insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client)
    {
        client = service.update(id, client);
        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
