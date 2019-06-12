package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	@Query("SELECT v FROM Venda v where codigo_cliente = ?1")
	public Venda findByCliente(Long codigoCliente);
	
	@Query("SELECT v FROM Venda v where codigo_vendedor = ?1")
	public Venda findByVendedor(Long codigoVendedor);
}
