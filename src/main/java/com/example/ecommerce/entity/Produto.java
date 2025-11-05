package com.example.ecommerce.entity;

import com.example.ecommerce.aggregates.ProdutoAgregado;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Produto {
    //  id , nome , descricao , categoria, quantidadeEstoque , preço , fornecedor e lista de avaliações 
    @Id
    private Long idProduto;
    private String nome;
    private String descricao;
    @OneToOne
    private Categoria categoria;
    private int quantidadeEstoque;
    private double preco;
    @OneToOne
    private Fornecedor fornecedor;
    @OneToOne
    private ProdutoAgregado produtoAgregado;
}
