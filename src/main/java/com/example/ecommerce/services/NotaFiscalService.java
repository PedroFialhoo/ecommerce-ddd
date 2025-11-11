package com.example.ecommerce.services;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.NotaFiscal;
import com.example.ecommerce.entity.Pedido;
import com.example.ecommerce.repository.NotaFiscalRepository;


@Service
public class NotaFiscalService {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    public NotaFiscal gerarNotaFiscal(Pedido pedido){
        NotaFiscal notaFiscal = new NotaFiscal(); 
        Long numeroNota = gerarNumeroDeNota();   
        notaFiscal.setNumeroNotaFiscal(numeroNota);
        notaFiscal.setChaveAcesso(gerarChaveAcesso(numeroNota));
        notaFiscal.setDataEmissao(LocalDate.now());
        notaFiscal.setPedido(pedido);
        notaFiscal.setValorTotal(pedido.getValorTotal());

        return notaFiscal;
    }

    public Long gerarNumeroDeNota(){
        LocalDate hoje = LocalDate.now();
        int ano = hoje.getYear();
        int mes = hoje.getMonthValue();
        int dia = hoje.getDayOfMonth();

        int aleatorio = new Random().nextInt(10000);

        String numeroStr = String.format("%d%02d%02d%04d", ano, mes, dia, aleatorio);
        Long numeroNotaFiscal = Long.parseLong(numeroStr);

        return numeroNotaFiscal;
    }

    public String gerarChaveAcesso(Long numeroNota){
        String chaveAcesso = "http://notafiscal." + numeroNota;
        return chaveAcesso;
    }

    public void salvarNotaFiscal(NotaFiscal notaFiscal){
        notaFiscalRepository.save(notaFiscal);
    }

}
