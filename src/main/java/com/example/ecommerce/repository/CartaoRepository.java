package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entity.Cartao;

@Repository
public interface  CartaoRepository extends JpaRepository<Cartao, Long>{

}
