package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.aggregates.PedidoAgregado;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
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

    @Embedded
    private PedidoAgregado pedidoAgregado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
