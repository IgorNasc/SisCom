package com.sis.com.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "venda")
public class Venda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	@Column(name="forma_pagto")
	private int formaPagto;
	@Column(name="data_venda")
	private Date dataVenda;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_cliente")
	private Cliente cliente;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_vendedor")
	private Vendedor vendedor;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venda")
	private List<ItemVenda> listaVenda;
	
	public Venda() {
		
	}
	
	public Venda(Long codigo,Cliente cliente,Vendedor vendedor,ArrayList<ItemVenda> listaVenda,int formaPagto,Date dataVenda) {
		super();
		this.codigo=codigo;
		this.cliente=cliente;
		this.vendedor=vendedor;
		this.listaVenda=listaVenda;
		this.formaPagto=formaPagto;
		this.dataVenda=dataVenda;
	}

	public Long getNumVenda() {
		return codigo;
	}
	public void setNumVenda(long codigo) {
		this.codigo = codigo;
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

	public List<ItemVenda> getListaVenda() {
		return listaVenda;
	}
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
		return "Venda [numVenda=" + codigo + ", cliente=" + cliente + ", vendedor=" + vendedor + ", formaPagto="
				+ formaPagto + ", dataVenda=" + dataVenda + "]";
	}
	
}
