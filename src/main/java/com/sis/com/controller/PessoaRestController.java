package com.sis.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.com.business.model.Pessoa;
import com.sis.com.business.service.PessoaService;

@CrossOrigin
@RestController
@RequestMapping("/pessoa")
public class PessoaRestController {
	
	@Autowired
	private PessoaService pessoaService;  
	
	@GetMapping("/findAll")
	public RestOutput<Pessoa> findAllPessoa() {
		RestOutput<Pessoa> restOutput = new RestOutput<Pessoa>();
		
		try {
			restOutput.setListEntity(pessoaService.findAllPessoa());
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		return restOutput;
	}
}
