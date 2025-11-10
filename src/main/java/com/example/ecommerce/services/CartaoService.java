package com.example.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Cartao;
import com.example.ecommerce.repository.CartaoRepository;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;
    
    public Boolean validarCartao(Cartao cartao, Long idCliente) {
        if(cartao.getCliente().getIdCliente().equals(idCliente)){
           return true;  
        }
        return false;
    }
}
