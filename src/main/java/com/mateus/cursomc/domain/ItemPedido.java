package com.mateus.cursomc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	private BigDecimal preco;
	private BigDecimal desconto;
	private Integer quantidade;

	public ItemPedido() {

	}

	public ItemPedido(Pedido pedido, Produto produto, BigDecimal preco, BigDecimal desconto, Integer quantidade) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.preco = preco;
		this.desconto = desconto;
		this.quantidade = quantidade;
	}
	
	public BigDecimal getSubtotal () {
		return (preco.subtract(desconto)).multiply(new BigDecimal(quantidade)) ; 
	}
	
	@JsonIgnore
	public Pedido getPedido () {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
