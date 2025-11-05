package com.example.ecommerce.aggregates;

import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.entity.Avaliacao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class ProdutoAgregado {
    
    @Id
    private Long idProdutoAgregado;
    @Transient
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}
