package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.valuableObject.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class User {
    //Usuário  -> id, nome , senha , email ,dataCadastro , boolean ativo , userRole
    @Id
    private Long idUser;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataCadastro;
    private boolean statusConta;
    @Enumerated
    private UserRole userRole;
    
}
