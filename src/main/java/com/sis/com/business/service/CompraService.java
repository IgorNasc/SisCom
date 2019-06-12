package com.sis.com.business.service;

import java.util.Date;
import java.util.List;

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

	public List<Compra> findAll() {
		List<Compra> teste =compraRepository.findAll(); 
		
		return teste;
	}
	
	public void compraFornecedor(Compra compra) throws SisComException {
		compra.setDataCompra(new Date());
		Compra newCompra = compraRepository.save(compra);
		
		for (ItemCompra itemCompra : compra.getListaCompra()) {
			Produto produto = produtoRepository.getOne(itemCompra.getProduto().getCodigo());
			
			if(produto == null) {
				throw new SisComException("Este produto não existe!");
			}
			
			produto.adicionaQuantidade(itemCompra.getQuantCompra());
			produtoRepository.save(produto);
			
			
			itemCompra.setCompra(newCompra);
			itemCompra.setValorCompra(produto.getPrecoUnitario() * itemCompra.getQuantCompra());
			
			itemCompraRepository.save(itemCompra);
		}
	}
	
	public void excluirCompra(Long codigo) throws SisComException {
		Compra compra = compraRepository.getOne(codigo);
		
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
		
		compraRepository.deleteById(codigo);
	}
}
