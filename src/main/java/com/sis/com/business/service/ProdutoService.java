package com.sis.com.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.ItemVenda;
import com.sis.com.business.model.Produto;
import com.sis.com.repository.ItemVendaRepository;
import com.sis.com.repository.ProdutoRepository;
import com.sis.com.system.SisComException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemVendaRepository itemVendaRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public void cadastrar(Produto produto) throws SisComException {
		produto.setDataCad(new Date());
		produtoRepository.save(produto);
	}
	
	public void deletar (Long codigo) throws SisComException {
		ItemVenda checkItemVenda = itemVendaRepository.findByProduto(codigo);
		
		if(checkItemVenda != null) {
			throw new SisComException("Este fornecedor possui compras!");
		}
		
		produtoRepository.deleteById(codigo);
	}
	
	/**
	 * Metodo que busca todos os produtos
	 * que tem o estoque menor que o seu
	 * estoque mínimo.
	 * @return List<Produto>
	 */
	public List<Produto> findEstoqueLessThenMinimo(){
		return produtoRepository.findEstoqueLessThenMinimo();
	}
}
