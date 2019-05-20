package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	@Query("SELECT p FROM Pessoa p WHERE p.nome = ?1")
	Pessoa findByNome(String nome);
}
