/**
 * 
 */
package com.sis.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Produto;

/**
 * @author AndradI1
 *
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("SELECT p FROM Produto p where p.estoque < p.estoque_minimo")
	public List<Produto> findEstoqueLessThenMinimo();
}
