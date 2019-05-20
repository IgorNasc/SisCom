package com.sis.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.com.model.Fornecedor;

import coms.sis.com.service.PessoaService;

@CrossOrigin
@RestController
@RequestMapping("/pessoa")
public class PessoaRestController {
	
	@Autowired
	private PessoaService pessoaService;  
	
	@PostMapping("/cadastrar/fornecedor")
	public Fornecedor cadastrarFornecedor(@RequestBody RestInput input) {
		return pessoaService.cadastrarFornecedor();
	}
}
