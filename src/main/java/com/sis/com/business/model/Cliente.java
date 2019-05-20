package com.sis.com.business.model;

import java.util.Date;

public class Cliente extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private double limiteCredito;
	
	public Cliente(Long codigo, String nome, String telefones, String email,
			Date dataCad, String cpf, double limiteCredito) {
		super(codigo, nome, telefones, email, dataCad);
		this.cpf = cpf;
		this.limiteCredito = limiteCredito;
	}

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
