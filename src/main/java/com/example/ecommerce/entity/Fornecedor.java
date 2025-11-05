package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Fornecedor{
    
    @Id
    private Long idFornecedor;
    @OneToOne
    private User user;
}
