package com.sis.com.business.model;

import java.util.Date;

public class Vendedor extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private double metaMensal;
	
	public Vendedor(Long codigo, String nome, String telefones, String email, Date dataCad, String cpf,
			double metaMensal) {
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
