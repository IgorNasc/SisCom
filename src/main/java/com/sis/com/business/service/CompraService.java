package com.sis.com.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.Compra;
import com.sis.com.business.model.ItemCompra;
import com.sis.com.business.model.Produto;
import com.sis.com.repository.CompraRepository;
import com.sis.com.repository.ItemCompraRepository;
import com.sis.com.repository.ProdutoRepository;
import com.sis.com.system.SisComException;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemCompraRepository itemCompraRepository;
	
	public void compraFornecedor(Compra compra) throws SisComException {
		Compra newCompra = compraRepository.save(compra);
		
		for (ItemCompra itemCompra : compra.getListaCompra()) {
			itemCompra.setCompra(newCompra);
			
			Produto produto = produtoRepository.getOne(itemCompra.getProduto().getCodigo());
			
			if(produto == null) {
				throw new SisComException("Este produto não existe!");
			}
			
			produto.adicionaQuantidade(itemCompra.getQuantCompra());
			
			produtoRepository.save(produto);
			
			itemCompraRepository.save(itemCompra);
		}
	}
	
	public void excluirCompra(Compra compra) throws SisComException {
		compraRepository.delete(compra);
		
		for (ItemCompra itemCompra : compra.getListaCompra()) {
			itemCompra.setCompra(compra);
			
			Produto produto = produtoRepository.getOne(itemCompra.getProduto().getCodigo());
			
			if(produto == null) {
				throw new SisComException("Este produto não existe!");
			}
			
			produto.decrementaQuantidade(itemCompra.getQuantCompra());
			
			produtoRepository.save(produto);
			
			itemCompraRepository.delete(itemCompra);
		}
	}
}
