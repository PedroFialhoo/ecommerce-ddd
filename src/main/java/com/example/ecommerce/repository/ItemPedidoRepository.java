package com.example.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entity.ItemPedido;
import com.example.ecommerce.entity.Produto;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
    Optional<ItemPedido> findByProduto(Produto produto);
}
