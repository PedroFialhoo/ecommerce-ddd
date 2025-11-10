package com.example.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entity.Carrinho;
import com.example.ecommerce.entity.Cliente;

@Repository
public interface  CarrinhoRepository extends JpaRepository<Carrinho, Long>{

    Optional<Carrinho> findByCliente(Cliente cliente);
    
}
