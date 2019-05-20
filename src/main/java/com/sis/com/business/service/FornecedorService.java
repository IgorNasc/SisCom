package com.sis.com.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.Fornecedor;
import com.sis.com.repository.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<Fornecedor> findAll(){
		return fornecedorRepository.findAll();
	}
}
