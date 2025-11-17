package com.example.ecommerce.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Carrinho;
import com.example.ecommerce.entity.Cliente;
import com.example.ecommerce.entity.ItemPedido;
import com.example.ecommerce.entity.Produto;
import com.example.ecommerce.repository.CarrinhoRepository;
import com.example.ecommerce.repository.ProdutoRepository;
import com.example.ecommerce.repository.ClienteRepository;
import com.example.ecommerce.repository.ItemPedidoRepository;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    

    public void adicionarItemAoCarrinho(Long produtoId, int quantidade, Long clienteId) {
        var clienteOpt = clienteRepository.findById(clienteId);
        if(!clienteOpt.isPresent()){
            return;
        }
        Cliente cliente = clienteOpt.get();
        var carrinhoOpt = carrinhoRepository.findByCliente(cliente);
        if(!carrinhoOpt.isPresent()){
            return;
        }
        Carrinho carrinho = carrinhoOpt.get();
        var produtoOpt = produtoRepository.findById(produtoId);
        if(!produtoOpt.isPresent()){
            return;
        }
        Produto produto = produtoOpt.get();
        var itemPedidoOpt = itemPedidoRepository.findByProduto(produto);
        if(!itemPedidoOpt.isPresent()){
            return;
        }
        ItemPedido itemPedido = itemPedidoOpt.get();
        
        carrinho.setQuantidadeItens(carrinho.getQuantidadeItens() + quantidade);
        carrinho.getCarrinhoAgregado().getItens().add(itemPedido);
        carrinho.setValorTotal(itemPedido.getValorUnitario() * quantidade);
        carrinhoRepository.save(carrinho);
    }

    public void limparCarrinho(Carrinho carrinho){
        List<ItemPedido> itens = carrinho.getCarrinhoAgregado().getItens();
        itens.removeIf(ItemPedido::isComprar);
        carrinhoRepository.save(carrinho); 
    }
}
