package com.sis.com.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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
@Table(name = "compra")
public class Compra implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	@Column(name="data_compra")
	private Date dataCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_fornecedor")
	private Fornecedor fornecedor;
	
	public Compra() {
		
	}
	
	public Compra(Long numCompra,Fornecedor fornecedor,ArrayList<ItemCompra> compraItens,Date dataCompra){
		this.codigo=numCompra;
		this.fornecedor=fornecedor;
		this.dataCompra=dataCompra;
	}

	public Long getNumCompra() {
		return codigo;
	}
	public void setNumCompra(Long numCompra) {
		this.codigo = numCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String toString() {
		return "Compra [codigo=" + codigo + ", fornecedor=" + fornecedor + ", dataCompra=" + dataCompra + "]";
	}
	
}
