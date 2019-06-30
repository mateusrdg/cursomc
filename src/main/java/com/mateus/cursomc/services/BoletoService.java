package com.mateus.cursomc.services;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.mateus.cursomc.domain.PagamentoComBoleto;
@Service
public class BoletoService {
	
	public void preencherPagamento(PagamentoComBoleto pagto, Calendar instant) {
		instant.add(Calendar.MONTH, 1);
		pagto.setDatavaVencimento(instant);	
	}
	
}
