package com.sis.com.business.service;

import java.util.Date;
import java.util.List;

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

	public List<Vendedor> findAll() {
		return vendedorRepository.findAll();
	}
	
	public void cadastrarVendedor(Vendedor vendedor) throws SisComException {
		Vendedor validaVendedor = vendedorRepository.findByCpf(vendedor.getCpf());
		
		if(validaVendedor != null) {
			throw new SisComException("Este vendedor de CPF: " + vendedor.getCpf() + ", já está cadastrado!");
		} else if(vendedor.getMetaMensal() <= 0) {
			throw new SisComException("O vendedor precisa ter uma meta mensal maior que 0(zero)!");
		} else {
			vendedor.setDataCad(new Date());
			vendedorRepository.save(vendedor);
		}
	}
	
	public void delete(Long codigo) throws SisComException{
		
		Venda checkVenda = vendaRepository.findByVendedor(codigo);
		
		if(checkVenda != null) {
			throw new SisComException("Este vendedor possui venda!");
		}
		
		vendedorRepository.deleteById(codigo);
	}
}
