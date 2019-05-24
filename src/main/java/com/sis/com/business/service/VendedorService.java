package com.sis.com.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.Venda;
import com.sis.com.business.model.Vendedor;
import com.sis.com.repository.VendaRepository;
import com.sis.com.repository.VendedorRepository;
import com.sis.com.system.SisComException;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public void cadastrarVendedor(Vendedor vendedor) throws SisComException {
		Vendedor validaVendedor = vendedorRepository.findByCpf(vendedor.getCpf());
		
		if(validaVendedor != null) {
			throw new SisComException("Este vendedor de CPF: " + vendedor.getCpf() + ", já está cadastrado!");
		} else if(vendedor.getMetaMensal() <= 0) {
			throw new SisComException("O vendedor precisa ter uma meta mensal maior que 0(zero)!");
		} else {
			vendedorRepository.save(vendedor);
		}
	}
	
	public void delete(Vendedor vendedor) throws SisComException{
		
		Venda checkVenda = vendaRepository.findByVendedor(vendedor.getCodigo());
		
		if(checkVenda != null) {
			throw new SisComException("Este vendedor possui venda!");
		}
		
		vendedorRepository.delete(vendedor);
	}
}
