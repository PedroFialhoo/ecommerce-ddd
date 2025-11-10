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
public class Endereco {
    @Id
    private Long idEndereco;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
