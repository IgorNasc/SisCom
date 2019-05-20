package com.sis.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.com.business.model.Fornecedor;
import com.sis.com.business.service.FornecedorService;

@CrossOrigin
@RestController
@RequestMapping("/fornecedor")
public class FornecedorRestController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("/findAll")
	public RestOutput<Fornecedor> findAllFornecedor(){
		RestOutput<Fornecedor> restOutput = new RestOutput<Fornecedor>();
		
		try {
			restOutput.setListEntity(fornecedorService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restOutput;
	}
}
