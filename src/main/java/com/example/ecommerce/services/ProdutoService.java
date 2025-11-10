package com.example.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Produto;
import com.example.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository produtoRepository;

    public void retirarProduto(Produto produto, int quantidade){
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
        produtoRepository.save(produto);
    }
}
