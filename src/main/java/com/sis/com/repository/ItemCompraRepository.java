package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.ItemCompra;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {

}
