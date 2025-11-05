package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.aggregates.CarrinhoAgregado;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Carrinho {
    @Id
    private Long idCarrinho;
    @OneToOne
    private Cliente cliente;
    private double valorTotal;
    private int quantidadeItens;
    private LocalDate dataAtualizacao;
    @OneToOne
    private CarrinhoAgregado carrinhoAgregado;
}
