package com.mateus.cursomc.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mateus.cursomc.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	@Temporal(value = TemporalType.DATE)
	private Calendar datavaVencimento;
	@Temporal(value = TemporalType.DATE)
	private Calendar dataPagamento;

	public PagamentoComBoleto() {
	}
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Calendar datavaVencimento, Calendar dataPagamento) {
		super(id, estado, pedido);
		this.datavaVencimento = datavaVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Calendar getDatavaVencimento() {
		return datavaVencimento;
	}

	public void setDatavaVencimento(Calendar datavaVencimento) {
		this.datavaVencimento = datavaVencimento;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
}
