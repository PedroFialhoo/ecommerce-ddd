package com.example.ecommerce.factory;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.services.CartaoService;
import com.example.ecommerce.services.ProdutoService;
import com.example.ecommerce.valuableObject.StatusPedido;

public class PedidoFactory {
    @Autowired
    CartaoService cartaoService;

    @Autowired
    ProdutoService produtoService;

    public boolean realizarPedido(Carrinho carrinho, Cliente cliente, Cartao cartao){
        boolean cartaoValido = cartaoService.validarCartao(cartao, cliente.getIdCliente());
        if(!cartaoValido){
            return false;
        }
        List<ItemPedido> itens = carrinho.getCarrinhoAgregado().getItens();
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            if(produto.getQuantidadeEstoque() < item.getQuantidade()){
                return false;
            }
            produtoService.retirarProduto(produto, item.getQuantidade());            
        }
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDate.now());
        pedido.setValorTotal(carrinho.getValorTotal());
        pedido.setPagamento(null);
        pedido.setNotaFiscal(null);
        pedido.setStatusPedido(StatusPedido.EM_PREPARO);
        pedido.getPedidoAgregado().setItensPedido(itens);;
        
        return true;
    }
}
