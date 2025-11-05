package com.example.ecommerce.aggregates;

import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.entity.ItemPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class CarrinhoAgregado {

    @Id
    private Long idCarrinhoAgregado;
    @Transient
    private List<ItemPedido> itens = new ArrayList<>();
}
