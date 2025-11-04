package com.example.ecommerce.aggregates;

import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.entity.Avaliacao;
import com.example.ecommerce.entity.Cartao;
import com.example.ecommerce.entity.Pedido;
import com.example.ecommerce.entity.Endereco;

public class ClienteAgregado {
    
    @SuppressWarnings("unused")
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Cartao> cartoes = new ArrayList<>();
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();
}
