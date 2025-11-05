package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.aggregates.PedidoAgregado;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {
    // lista itens, cliente , dataCriação , valorTotal, Pagemento , Nota Fiscal , status
    @Id
    private Long idPedido;
    private LocalDate dataPedido;
    private double valorTotal;
    @OneToOne
    private Pagamento pagamento;
    @OneToOne
    private NotaFiscal notaFiscal;
    private boolean statusPedido;
    @OneToOne
    private PedidoAgregado pedidoAgregado;
}
