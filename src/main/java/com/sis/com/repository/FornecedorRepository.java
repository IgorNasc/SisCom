package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	@Query("SELECT f FROM Fornecedor f WHERE f.cnpj = ?1")
    Fornecedor findByCnpj(String cnpj);
}
