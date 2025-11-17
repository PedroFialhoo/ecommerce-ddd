package com.example.ecommerce.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Carrinho;
import com.example.ecommerce.entity.Cliente;
import com.example.ecommerce.entity.ItemPedido;
import com.example.ecommerce.entity.Pedido;
import com.example.ecommerce.repository.PedidoRepository;
import com.example.ecommerce.valuableObject.StatusPedido;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido criarPedido(Cliente cliente, float total, List<ItemPedido> itens){
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDate.now());
        pedido.setValorTotal(total);
        pedido.setStatusPedido(StatusPedido.ESPERANDO_PAGAMENTO);
        pedido.getPedidoAgregado().setItensPedido(itens);

        return pedido;
    }

    public void salvarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
