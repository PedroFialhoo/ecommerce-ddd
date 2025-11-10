package com.example.ecommerce.aggregates;

import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.entity.Avaliacao;
import com.example.ecommerce.entity.Cartao;
import com.example.ecommerce.entity.Endereco;
import com.example.ecommerce.entity.Pedido;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

@Embeddable
public class ClienteAgregado {
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Cartao> cartoes = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();
}
