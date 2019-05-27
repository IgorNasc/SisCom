package com.sis.com.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void cadastrar(Produto produto) throws SisComException {
		produtoRepository.save(produto);
	}
	
	public void deletar (Produto produto) throws SisComException {
		if(itemVendaRepository.findByProduto(produto.getCodigo())) {
			
		}
		
		produtoRepository.delete(produto);
	}
}
