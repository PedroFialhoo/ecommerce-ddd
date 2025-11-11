package com.example.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Cartao;
import com.example.ecommerce.entity.Pedido;
import com.example.ecommerce.valuableObject.TipoPagamento;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

import com.example.ecommerce.entity.Pagamento;
import com.example.ecommerce.repository.PagamentoRepository;
import com.example.ecommerce.valuableObject.StatusPagamento;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    public Boolean processarPagamento(Pedido pedido, Cartao cartao, TipoPagamento tipoPagamento) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> dados = Map.of(
                "cartao", cartao.getNumeroCartao(),
                "valor", pedido.getValorTotal(),
                "tipoPagamento", tipoPagamento
            );
                        
            String json = mapper.writeValueAsString(dados); 
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://aprovar-pagamento.com"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public void salvarPagamento(Pedido pedido, TipoPagamento tipoPagamento, Double valorPago){
        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setTipoPagamento(tipoPagamento);
        pagamento.setStatusPagamento(StatusPagamento.CONCLUIDO);
        pagamento.setValorPago(valorPago);
        pagamento.setDataPagamento(LocalDate.now());
        
        pagamentoRepository.save(pagamento);
    }

  
}
