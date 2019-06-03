package com.sis.com.business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	@Id
	@Column(name="codigo")
	private Long codigo;

	@Column(name="quant_venda")
	private int quantVenda;
	@Column(name="valor_venda")
	private double valorVenda;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_produto")
	private Produto produto;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_venda")
	private Venda venda;
	
	public ItemVenda() {
		
	}
	
	public ItemVenda(Produto produto, int quantVenda, double valorVenda, Venda venda) {
		super();
		this.produto = produto;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantVenda() {
		return quantVenda;
	}
	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		return "ItemVenda [quantVenda=" + quantVenda + ", valorVenda=" + valorVenda + "]";
	}
	
}
