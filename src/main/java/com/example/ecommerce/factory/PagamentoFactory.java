package com.example.ecommerce.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.entity.Cartao;
import com.example.ecommerce.entity.NotaFiscal;
import com.example.ecommerce.entity.Pagamento;
import com.example.ecommerce.entity.Pedido;
import com.example.ecommerce.services.NotaFiscalService;
import com.example.ecommerce.services.PagamentoService;
import com.example.ecommerce.valuableObject.StatusPagamento;
import com.example.ecommerce.valuableObject.TipoPagamento;

public class PagamentoFactory {
    @Autowired
    PagamentoService pagamentoService;

    @Autowired
    NotaFiscalService notaFiscalService;
    
    public Pedido realizarPagamento(Pedido pedido, Cartao cartao, TipoPagamento tipoPagamento) {
        Pagamento pagamento = new Pagamento();
        pagamento.setStatusPagamento(StatusPagamento.AGUARDANDO);
        Boolean sucesso = pagamentoService.processarPagamento(pedido, cartao, tipoPagamento);
        if(!sucesso){
            return null;
        }
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal = notaFiscalService.gerarNotaFiscal(pedido);
        pagamentoService.salvarPagamento(pedido, tipoPagamento, notaFiscal.getValorTotal());
        notaFiscalService.salvarNotaFiscal(notaFiscal);
        pedido.setNotaFiscal(notaFiscal);
        pedido.setPagamento(pagamento);
        
        return pedido;
    }
}
