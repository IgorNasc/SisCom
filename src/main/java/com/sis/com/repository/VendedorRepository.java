package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	@Query("SELECT v FROM Vendedor v WHERE v.cpf = ?1")
	public Vendedor findByCpf(String cpf);
}