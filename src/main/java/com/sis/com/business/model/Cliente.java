package com.sis.com.business.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	@Column(name = "cpf", nullable = false)
	private String cpf;
	@Column(name = "limite_credito", nullable = false)
	private double limiteCredito;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	@JsonIgnore
    private List<Venda> vendas;
	
	// Constructors
	public Cliente() {
		
	}
	
	public Cliente(Long codigo, String nome, String telefones, String email,
			Date dataCad, String cpf, double limiteCredito) {
		super(codigo, nome, telefones, email, dataCad);
		this.cpf = cpf;
		this.limiteCredito = limiteCredito;
	}

	// Getters and Setters
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	// Extra functions
	public String toString() {
		return super.toString() + "Cliente [cpf=" + cpf + ", limiteCredito=" + limiteCredito + "]";
	}

	public int compareTo(Pessoa pessoa) {
		super.compareTo(pessoa);
		
		return 0;
	}

	public Pessoa retornaTipoPessoa() {
		return null;
	}
	
}
