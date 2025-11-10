package com.example.ecommerce.entity;

import com.example.ecommerce.aggregates.ProdutoAgregado;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nome;
    private String descricao;
    private int quantidadeEstoque;
    private double preco;

    @OneToOne
    private Fornecedor fornecedor;

    @Embedded
    private ProdutoAgregado produtoAgregado;
}
