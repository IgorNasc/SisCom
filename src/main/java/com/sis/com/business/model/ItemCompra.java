package com.sis.com.business.model;

public class ItemCompra {
	private Produto produto;
	private int quantCompra;
	private double valorCompra;
	
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

	public String toString() {
		return "ItemCompra [quantCompra=" + quantCompra + ", valorCompra=" + valorCompra + "]";
	}
	
}
