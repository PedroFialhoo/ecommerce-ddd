package com.example.ecommerce.entity;

import com.example.ecommerce.aggregates.ProdutoAgregado;

public class Produto {
    //  id , nome , descricao , categoria, quantidadeEstoque , preço , fornecedor e lista de avaliações 
    private Long idProduto;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private int quantidadeEstoque;
    private double preco;
    private Fornecedor fornecedor;
    private ProdutoAgregado produtoAgregado;
}
