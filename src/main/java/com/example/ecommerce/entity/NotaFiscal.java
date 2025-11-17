package com.example.ecommerce.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NotaFiscal {
    //id, pedido , numero , data Emissão ,valor total , chave de acesso
    @Id
    private Long idNotaFiscal;

    @OneToOne
    private Pedido pedido;
    private Long numeroNotaFiscal;
    private LocalDate dataEmissao;
    private double valorTotal;
    private String chaveAcesso;
    
}
