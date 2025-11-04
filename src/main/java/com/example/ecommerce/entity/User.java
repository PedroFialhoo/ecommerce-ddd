package com.example.ecommerce.entity;

import java.time.LocalDate;

import com.example.ecommerce.valuableObject.UserRole;

public class User {
    //Usuário  -> id, nome , senha , email ,dataCadastro , boolean ativo , userRole
    private Long idUser;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataCadastro;
    private boolean statusConta;
    private UserRole userRole;
    
}
