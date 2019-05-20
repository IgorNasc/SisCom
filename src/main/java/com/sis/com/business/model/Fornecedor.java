package com.sis.com.business.model;

import java.util.Date;

public class Fornecedor extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String nomeContato;

	public Fornecedor(Long codigo, String nome, String telefones, String email, Date dataCad, String cnpj,
			String nomeContato) {
		super(codigo, nome, telefones, email, dataCad);
		this.cnpj = cnpj;
		this.nomeContato = nomeContato;
	}
	
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
