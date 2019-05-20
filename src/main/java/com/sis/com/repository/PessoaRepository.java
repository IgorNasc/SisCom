package com.sis.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface PessoaRepository extends JpaRepository<PessoaRepository, Long>{
	Optional<PessoaRepository> findById(Long PessoaId);
}
