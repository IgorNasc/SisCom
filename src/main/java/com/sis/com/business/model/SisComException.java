package com.sis.com.business.model;

public class SisComException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeProduto;
	private int estoque;
	private String mensagemErro;
	
	public SisComException(String nomeProduto, int estoque, String mensagemErro) {
		super();
		this.nomeProduto = nomeProduto;
		this.estoque = estoque;
		this.mensagemErro = mensagemErro;
	}

	public SisComException(String mensagemErro) {
		super();
		this.mensagemErro = mensagemErro;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public int getEstoque() {
		return estoque;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}
}
