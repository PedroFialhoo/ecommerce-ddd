package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.aggregates.CarrinhoAgregado;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Carrinho {
    @Id
    private Long idCarrinho;
    @OneToOne
    private Cliente cliente;
    private double valorTotal;
    private int quantidadeItens;
    private LocalDate dataAtualizacao;
    
    @Embedded
    private CarrinhoAgregado carrinhoAgregado;
}
