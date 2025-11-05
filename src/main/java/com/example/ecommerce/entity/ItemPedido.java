package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ItemPedido {
    // produto, quantidade , valorUnitario, subtotal
    @Id
    private Long idItemPedido;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private int quantidade;
    private double valorUnitario;
    private double subtotal ;
    
}
