package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Cartao {
    @Id
    private Long idCartao;

    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
