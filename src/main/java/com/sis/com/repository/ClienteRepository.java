package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT c FROM Cliente c WHERE c.cpf = ?1")
	public Cliente FindByCpf(String cpf);
}
