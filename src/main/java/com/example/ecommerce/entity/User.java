package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.valuableObject.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
