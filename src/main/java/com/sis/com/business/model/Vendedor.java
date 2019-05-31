package com.sis.com.business.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "vendedor")
public class Vendedor extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	@Column(name = "meta_mensal", nullable = false)
	private double metaMensal;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendedor")
    private List<Venda> vendas;
	
	public Vendedor() {
		
	}
	
	public Vendedor(Long codigo, String nome, String telefones, String email, Date dataCad, String cpf,	double metaMensal) {
		super(codigo, nome, telefones, email, dataCad);
		this.cpf = cpf;
		this.metaMensal = metaMensal;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getMetaMensal() {
		return metaMensal;
	}
	public void setMetaMensal(double metaMensal) {
		this.metaMensal = metaMensal;
	}

	public String toString() {
		return super.toString() + "Vendedor [cpf=" + cpf + ", metaMensal=" + metaMensal + "]";
	}

	public int compareTo(Pessoa pessoa) {
		super.compareTo(pessoa);
		
		return 0;
	}

	public Pessoa retornaTipoPessoa() {
		// TODO Auto-generated method stub
		return null;
	}
}
