package com.example.ecommerce.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.entity.Carrinho;
import com.example.ecommerce.entity.Cartao;
import com.example.ecommerce.entity.Cliente;
import com.example.ecommerce.entity.ItemPedido;
import com.example.ecommerce.entity.Pedido;
import com.example.ecommerce.entity.Produto;
import com.example.ecommerce.services.CarrinhoService;
import com.example.ecommerce.services.CartaoService;
import com.example.ecommerce.services.PedidoService;
import com.example.ecommerce.services.ProdutoService;
import com.example.ecommerce.valuableObject.TipoPagamento;

public class PedidoFactory {
    @Autowired
    CartaoService cartaoService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    CarrinhoService carrinhoService;

    @Autowired
    PedidoService pedidoService;

    @Autowired
    PagamentoFactory pagamentoFactory;

    public boolean realizarPedido(Carrinho carrinho, Cliente cliente, TipoPagamento tipoPagamento, Cartao cartao) {
        if(cartao != null){
            boolean cartaoValido = cartaoService.validarCartao(cartao, cliente.getIdCliente());
            if(!cartaoValido){
                return false;
            }
        }        
        List<ItemPedido> itens = new ArrayList<>();
        float total = 0;
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            if(!item.isComprar()){
                return false;
            }
            if(produto.getQuantidadeEstoque() < item.getQuantidade()){
                return false;
            }
            itens.add(item);
            total += produto.getPreco() * item.getQuantidade();
            produtoService.retirarProduto(produto, item.getQuantidade());            
        }
        
        Pedido pedido = new Pedido();
        pedido = pedidoService.criarPedido(cliente, total, itens);
        pedido = pagamentoFactory.realizarPagamento(pedido, cartao, tipoPagamento);
        
        pedidoService.salvarPedido(pedido);
        carrinhoService.limparCarrinho(carrinho);

        return true;
    }
}
