package com.sis.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.com.business.model.Compra;
import com.sis.com.business.service.CompraService;
import com.sis.com.system.SisComException;

@CrossOrigin
@RestController
@RequestMapping("/compra")
public class CompraRestController {
	
	@Autowired
	private CompraService compraService;

	@PostMapping("/fornecedor")
	public RestOutput<Compra> compraFornecedor(@RequestBody RestInput<Compra> restInput){
		
		RestOutput<Compra> restOutput = new RestOutput<Compra>();
		
		try {
			compraService.compraFornecedor(restInput.getEntity());
			restOutput.setStatus(201);
		} catch (SisComException e) {
			restOutput.addWarn(e.getMenssagemErro());
			restOutput.setStatus(409);
		}  catch (Exception e) {
			restOutput.setStatus(500);
		}
		
		return restOutput;
	}
}
