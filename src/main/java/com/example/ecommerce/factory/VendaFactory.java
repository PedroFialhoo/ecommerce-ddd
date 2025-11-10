package com.example.ecommerce.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.entity.Carrinho;
import com.example.ecommerce.entity.Cartao;
import com.example.ecommerce.entity.Cliente;

public class VendaFactory {
    @Autowired
    PedidoFactory pedidoFactory;

    public void registrarVenda(Carrinho carrinho, Cliente cliente, Cartao cartao){
        Boolean pedido = pedidoFactory.realizarPedido(carrinho, cliente, cartao);
    }
}
