package com.example.ecommerce.entity;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;

import com.example.ecommerce.valuableObject.TipoPagamento;
import com.example.ecommerce.valuableObject.StatusPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    
    @Id
    private Long idPagamento;

    @OneToOne
    private Pedido pedido;
    private TipoPagamento tipoPagamento;
    private StatusPagamento statusPagamento;
    private Double valorPago;
    private LocalDate dataPagamento;
}
