package com.mateus.cursomc.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mateus.cursomc.domain.enums.EstadoPagamento;
@Entity
@JsonTypeName("")
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(value = TemporalType.DATE)
	private Calendar datavaVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
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
