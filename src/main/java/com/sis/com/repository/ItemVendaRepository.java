package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.ItemVenda;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

	@Query("SELECT iv FROM ItemVenda iv where codigo_produto = ?1")
	public ItemVenda findByProduto(Long codigoProduto);
}
