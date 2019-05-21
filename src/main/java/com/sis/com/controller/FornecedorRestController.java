package com.sis.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.com.business.model.Fornecedor;
import com.sis.com.business.service.FornecedorService;
import com.sis.com.system.SisComException;

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
	
	@PostMapping("/cadastrar")
	public RestOutput<Fornecedor> cadastrarFornecedor(@RequestBody RestInput<Fornecedor> restInput){
		RestOutput<Fornecedor> restOutput = new RestOutput<Fornecedor>();
		
		try {
			fornecedorService.cadastrar(restInput.getEntity());
			restOutput.setStatus(201);
		} catch (SisComException e) {
			restOutput.addWarn(e.getMenssagemErro());
			restOutput.setStatus(409);
		} catch (Exception e) {
			e.printStackTrace();
			restOutput.setStatus(500);
		}
		
		return restOutput;
	}
}
