/**
 * 
 */
package com.sis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sis.com.business.model.Produto;

/**
 * @author AndradI1
 *
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
