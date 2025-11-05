package com.example.ecommerce.aggregates;

import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.entity.Avaliacao;
import com.example.ecommerce.entity.Cartao;
import com.example.ecommerce.entity.Pedido;
import com.example.ecommerce.entity.Endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class ClienteAgregado {
        
    @Id
    private Long idClienteAgregado;
    @Transient
    private List<Pedido> pedidos = new ArrayList<>();
    @Transient
    private List<Cartao> cartoes = new ArrayList<>();
    @Transient
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    @Transient
    private List<Endereco> enderecos = new ArrayList<>();
}
