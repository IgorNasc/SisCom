package com.sis.com.business.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * 
 * @author igor
 * createAt: 17/04/19
 * 
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Comparable<Pessoa>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	@Column(name="nome", nullable = false)
	private String nome;
	@Column(name="telefones", nullable = true)
	private String telefones;
	@Column(name="email", nullable = true)
	private String email;
	@Column(name="dataCad", nullable = false)
	private Date dataCad;
	
	public Pessoa() {
		
	}
	
	public Pessoa(Long codigo, String nome, String telefones, String email, Date dataCad) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefones = telefones;
		this.email = email;
		this.dataCad = dataCad;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefones() {
		return telefones;
	}
	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCad() {
		return dataCad;
	}
	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
	
	public int compareTo(Pessoa pessoa) {
		if (this.nome.length() < pessoa.nome.length()) {
            return -1;
        }
        if (this.nome.length() > pessoa.nome.length()) {
            return 1;
        }
		return 0;
	}
	
	//public abstract Pessoa retornaTipoPessoa();

	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", telefones=" 
				+ telefones + ", email=" + email + ", dataCad=" + dataCad + "]";
	}

}
