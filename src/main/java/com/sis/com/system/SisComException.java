package com.sis.com.system;

public class SisComException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeProduto;
	private int estoque;
	private String menssagemErro;
	
	public SisComException(String nomeProduto, int estoque, String menssagemErro) {
		this.nomeProduto = nomeProduto;
		this.estoque = estoque;
		this.menssagemErro = menssagemErro;
	}
	
	public SisComException(String menssagemErro) {
		this.menssagemErro = menssagemErro;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public int getEstoque() {
		return estoque;
	}

	public String getMenssagemErro() {
		return menssagemErro;
	}

}
