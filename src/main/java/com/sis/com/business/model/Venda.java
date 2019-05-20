package com.sis.com.business.model;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
	private int numVenda;
	private Cliente cliente;
	private Vendedor vendedor;
	private ArrayList<ItemVenda> listaVenda;
	private int formaPagto;
	private Date dataVenda;
	
	public Venda(int numVenda,Cliente cliente,Vendedor vendedor,ArrayList<ItemVenda> listaVenda,int formaPagto,Date dataVenda){super();this.numVenda=numVenda;this.cliente=cliente;this.vendedor=vendedor;this.listaVenda=listaVenda;this.formaPagto=formaPagto;this.dataVenda=dataVenda;}

	public int getNumVenda() {
		return numVenda;
	}
	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public ArrayList<ItemVenda> getListaVenda() {
	return listaVenda;}
	public void setListaVenda(ArrayList<ItemVenda> listaVenda) {
	this.listaVenda = listaVenda;}

	public int getFormaPagto() {
		return formaPagto;
	}
	public void setFormaPagto(int formaPagto) {
		this.formaPagto = formaPagto;
	}

	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String toString() {
		return "Venda [numVenda=" + numVenda + ", cliente=" + cliente + ", vendedor=" + vendedor + ", formaPagto="
				+ formaPagto + ", dataVenda=" + dataVenda + "]";
	}
	
}
