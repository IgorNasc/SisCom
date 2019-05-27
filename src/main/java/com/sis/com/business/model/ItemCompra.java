package com.sis.com.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_compra")
public class ItemCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private int codigo;
	@Column(name="quant_compra")
	private int quantCompra;
	@Column(name="valor_compra")
	private double valorCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_produto")
	private Produto produto;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_compra")
	private Compra compra;
	
	public ItemCompra(Produto produto, int quantCompra, double valorCompra) {
		super();
		this.produto = produto;
		this.quantCompra = quantCompra;
		this.valorCompra = valorCompra;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantCompra() {
		return quantCompra;
	}
	public void setQuantCompra(int quantCompra) {
		this.quantCompra = quantCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public String toString() {
		return "ItemCompra [quantCompra=" + quantCompra + ", valorCompra=" + valorCompra + "]";
	}
	
}
