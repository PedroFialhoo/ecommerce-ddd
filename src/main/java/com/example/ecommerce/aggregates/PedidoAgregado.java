package com.example.ecommerce.aggregates;

import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.entity.ItemPedido;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PedidoAgregado {

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido = new ArrayList<>();
}
