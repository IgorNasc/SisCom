package com.sis.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/***
 * 
 * @author igor
 * createAt: 17/04/19
 * 
 */
@Entity
public abstract class Pessoa implements Comparable<Pessoa> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private String nome;
	private String telefones;
	private String email;
	private Date dataCad;
	
	public Pessoa(int codigo, String nome, String telefones, String email
			, Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefones = telefones;
		this.email = email;
		this.dataCad = dataCad;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
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
	
	public abstract Pessoa retornaTipoPessoa();

	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", telefones=" 
				+ telefones + ", email=" + email + ", dataCad=" + dataCad + "]";
	}

}
