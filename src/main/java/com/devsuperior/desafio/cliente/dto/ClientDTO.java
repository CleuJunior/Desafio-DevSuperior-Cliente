package com.devsuperior.desafio.cliente.dto;

import com.devsuperior.desafio.cliente.entities.Client;
import java.io.Serializable;
import java.time.Instant;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    public ClientDTO(){ }

    public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client clientEntity) {
        this.id = clientEntity.getId();
        this.name = clientEntity.getName();
        this.cpf = clientEntity.getCpf();
        this.income = clientEntity.getIncome();
        this.birthDate = clientEntity.getBirthDate();
        this.children = clientEntity.getChildren();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Double getIncome() { return income; }

    public void setIncome(Double income) { this.income = income; }

    public Instant getBirthDate() { return birthDate; }

    public void setBirthDate(Instant birthDate) { this.birthDate = birthDate; }

    public Integer getChildren() { return children; }

    public void setChildren(Integer children) { this.children = children; }
}
