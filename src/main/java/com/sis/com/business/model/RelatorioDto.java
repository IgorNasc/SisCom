package com.sis.com.business.model;


public class RelatorioDto {
	
	private String nome;
	private Long quant;
	private double total;

	public RelatorioDto(String nome, Long quant, double total) {
		super();
		this.nome = nome;
		this.quant = quant;
		this.total = total;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQuant() {
		return quant;
	}

	public void setQuant(Long quant) {
		this.quant = quant;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
