package com.devsuperior.desafio.cliente.resouces;

import com.devsuperior.desafio.cliente.entities.Client;
import com.devsuperior.desafio.cliente.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll()
    {
        List<Client> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

}
