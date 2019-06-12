package com.sis.com.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.ItemVenda;
import com.sis.com.business.model.Produto;
import com.sis.com.business.model.Venda;
import com.sis.com.repository.ItemVendaRepository;
import com.sis.com.repository.ProdutoRepository;
import com.sis.com.repository.VendaRepository;
import com.sis.com.system.SisComException;

@Service
public class VendaService {
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemVendaRepository itemVendaRepository;

	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}
	
	public void cadastrar(Venda venda) throws SisComException {
		venda.setDataVenda(new Date());
		Venda newVenda = vendaRepository.save(venda);
		
		for(ItemVenda itemVenda : venda.getListaVenda()) {
			Produto produto = produtoRepository.getOne(itemVenda.getProduto().getCodigo());
			
			if(produto == null) {
				throw new SisComException("Este produto não existe!");
			}
			
			produto.decrementaQuantidade(itemVenda.getQuantVenda());
			
			produtoRepository.save(produto);
			
			itemVenda.setVenda(newVenda);
			
			itemVenda.setValorVenda(produto.getPrecoUnitario() * itemVenda.getQuantVenda());
			
			itemVendaRepository.save(itemVenda);
		}
	}
	
	public void excluir(Long codigo) throws SisComException {
		Venda venda = vendaRepository.getOne(codigo);
		
		for(ItemVenda itemVenda : venda.getListaVenda()) {
			Produto produto = produtoRepository.getOne(itemVenda.getProduto().getCodigo());
			
			if(produto == null) {
				throw new SisComException("Este produto não existe!");
			}
			
			produto.adicionaQuantidade(itemVenda.getQuantVenda());
			
			produtoRepository.save(produto);
			itemVendaRepository.delete(itemVenda);
		}
		
		vendaRepository.delete(venda);
	}
}
