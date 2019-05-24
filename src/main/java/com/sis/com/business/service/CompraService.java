package com.sis.com.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.Compra;
import com.sis.com.repository.CompraRepository;
import com.sis.com.system.SisComException;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	public void compraFornecedor(Compra compra) throws SisComException {
		Compra newCompra = compraRepository.save(compra);
	}
}
