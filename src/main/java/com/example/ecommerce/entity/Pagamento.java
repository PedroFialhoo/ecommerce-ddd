package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pagamento {
    
    @Id
    private Long idPagamento;
}
