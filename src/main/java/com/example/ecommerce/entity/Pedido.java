package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.aggregates.PedidoAgregado;

public class Pedido {
    // lista itens, cliente , dataCriação , valorTotal, Pagemento , Nota Fiscal , status
    private Long idPedido;
    private LocalDate dataPedido;
    private double valorTotal;
    private Pagamento pagamento;
    private NotaFiscal notaFiscal;
    private boolean statusPedido;
    private PedidoAgregado pedidoAgregado;
}
