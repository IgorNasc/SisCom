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
@Table(name = "fornecedor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	@Column(name = "codigo", nullable = false)
	private Long codigo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	@JsonIgnore
    private List<Compra> compras;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

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
