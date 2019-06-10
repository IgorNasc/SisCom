package com.sis.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Pessoa;
import com.sis.com.business.model.RelatorioDto;

@Repository
public interface RelatorioRepository extends JpaRepository<Pessoa, Long> {
	
	@Query("SELECT new com.sis.com.business.model.RelatorioDto(p.nome, COUNT(p), SUM(iv.valorVenda)) " + 
			"FROM ItemVenda iv " + 
			"INNER JOIN Venda v on iv.venda.codigo = v.codigo " + 
			"INNER JOIN Pessoa as p on v.vendedor.codigo = p.codigo " + 
			"INNER JOIN Vendedor ve on p.codigo = ve.codigo " + 
			"GROUP BY p.nome")
	public List<RelatorioDto> relatorioVendaVendedor();	
	
	@Query("SELECT new com.sis.com.business.model.RelatorioDto(p.nome, COUNT(p), SUM(iv.valorVenda)) " + 
			"FROM ItemVenda iv " + 
			"INNER JOIN Venda v on iv.venda.codigo = v.codigo " + 
			"INNER JOIN Pessoa as p on v.cliente.codigo = p.codigo " + 
			"INNER JOIN Cliente cli on p.codigo = cli.codigo " + 
			"GROUP BY p.nome")
	public List<RelatorioDto> relatorioVendaCliente();
	
	@Query("SELECT new com.sis.com.business.model.RelatorioDto(p.nome, COUNT(p), SUM(ic.valorCompra)) " + 
			"FROM ItemCompra ic " + 
			"INNER JOIN Compra c on ic.compra.codigo = c.codigo " + 
			"INNER JOIN Pessoa as p on c.fornecedor.codigo = p.codigo " + 
			"INNER JOIN Fornecedor for on p.codigo = for.codigo " + 
			"GROUP BY p.nome")
	public List<RelatorioDto> relatorioCompraFornecedor();
}
