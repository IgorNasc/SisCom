package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query("SELECT c FROM Compra c WHERE codigo_fornecedor = ?1")
	public Compra findByCodigoFornecedor(Long codigoFornecedor); 
}
