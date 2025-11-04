package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.aggregates.ClienteAgregado;

public class Cliente extends User{
    // id, cpf, data nascimento , lista de pedidos , lista Cartões , lista de avaliações , telefone, endereço , usuario
    private Long idCliente;
    private int cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private ClienteAgregado clienteAgregado;

}
