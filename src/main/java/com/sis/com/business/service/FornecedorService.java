package com.sis.com.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.Fornecedor;
import com.sis.com.repository.FornecedorRepository;
import com.sis.com.system.SisComException;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository fornecedorRepository;

	public List<Fornecedor> findAll() {
		return fornecedorRepository.findAll();
	}

	public void cadastrar(Fornecedor fornecedor) throws SisComException {

		Fornecedor checkFornecedor = fornecedorRepository.findByCnpj(fornecedor.getCnpj());

		if (checkFornecedor != null) {
			throw new SisComException("Este fornecedor com o CNPJ: " + fornecedor.getCnpj() + ", já está cadastrado");
		}

		fornecedorRepository.save(fornecedor);
	}
	
	public void delete(Fornecedor fornecedor) throws SisComException{
		
	}
}
