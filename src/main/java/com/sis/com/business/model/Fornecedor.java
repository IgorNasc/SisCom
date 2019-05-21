package com.sis.com.business.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	@Column(name = "nome_contato", nullable = false)
	private String nomeContato;
	
	// Constructors
	public Fornecedor() {
		
	}

	public Fornecedor(Long codigo, String nome, String telefones, String email, Date dataCad,
			String cnpj, String nomeContato) {
		super(codigo, nome, telefones, email, dataCad);
		this.cnpj = cnpj;
		this.nomeContato = nomeContato;
	}
	
	
	// Getters and Setters
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	// Extra functions
	public String toString() {
		return super.toString() + "Fornecedor [cnpj=" + cnpj + ", nomeContato=" + nomeContato + "]";
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
