package com.sis.com.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.Fornecedor;
import com.sis.com.business.model.Pessoa;
import com.sis.com.repository.FornecedorRepository;
import com.sis.com.repository.PessoaRepository;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Fornecedor> findAll(){
		return fornecedorRepository.findAll();
	}
	
	public void cadastrar(Fornecedor fornecedor) {
		try {
			Fornecedor checkFornecedor = fornecedorRepository.findByCnpj(fornecedor.getCnpj());
			
			if(checkFornecedor == null) {
				Pessoa pessoa = pessoaRepository.findByNome(fornecedor.getNome());
				
//				if(pessoa == null) {
//					fornecedorRepository.save(fornecedor);
//				}
//				else {
//					fornecedorRepository.save(fornecedor);
//				}
				
				fornecedorRepository.save(fornecedor);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
