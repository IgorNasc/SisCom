package coms.sis.com.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.sis.com.model.Fornecedor;
import com.sis.com.repository.PessoaRepository;

public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Fornecedor cadastrarFornecedor() {
		return new Fornecedor(1, "", "", "", new Date(), "", "");
	}
}
