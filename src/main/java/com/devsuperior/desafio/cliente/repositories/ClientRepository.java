package com.devsuperior.desafio.cliente.repositories;

import com.devsuperior.desafio.cliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

