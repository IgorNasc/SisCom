package com.sis.com.business.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Comparable<Produto> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	@Column(name="nome")
	private String nome;
	@Column(name="preco_unitario")
	private double precoUnitario;
	@Column(name="estoque")
	private int estoque;
	@Column(name="estoque_minimo")
	private int estoqueMinimo;
	@Column(name="data_cad")
	private Date dataCad;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
    private List<ItemVenda> vendas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
    private List<ItemCompra> compras;
	
	public Produto() {
		
	}
	
	public Produto(Long codigo, String nome, double precoUnitario, int estoque, int estoqueMinimo, Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.estoque = estoque;
		this.estoqueMinimo = estoqueMinimo;
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

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
	
	public boolean adicionaQuantidade(int quant) {
		return true;
	}
	
	public boolean decrementaQuantidade(int quant) {
		// Caso n consiga decrementar retornar exception SisCOnEsception
		return true;
	}

	public int compareTo(Produto produto) {
		
		return 0;
	}

	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", precoUnitario=" + precoUnitario + ", estoque="
				+ estoque + ", estoqueMinimo=" + estoqueMinimo + ", dataCad=" + dataCad + "]";
	}
	
}
