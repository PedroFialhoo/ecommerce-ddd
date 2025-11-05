package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.aggregates.ClienteAgregado;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente{
    // id, cpf, data nascimento , lista de pedidos , lista Cartões , lista de avaliações , telefone, endereço , usuario
    @Id
    private Long idCliente;
    private int cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private ClienteAgregado clienteAgregado;
    @OneToOne
    private User user;

}
