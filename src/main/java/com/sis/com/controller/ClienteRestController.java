package com.sis.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.com.business.model.Cliente;
import com.sis.com.business.service.ClienteService;
import com.sis.com.system.SisComException;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cadastrar")
	public RestOutput<Cliente> cadastrarCliente(@RequestBody RestInput<Cliente> restInput){
		RestOutput<Cliente> restOutput = new RestOutput<Cliente>();
		
		try {
			clienteService.cadastrarCliente(restInput.getEntity());
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
	
	@DeleteMapping("/delete")
	public RestOutput<Cliente> deleteCliente(@RequestBody RestInput<Cliente> restInput){
		RestOutput<Cliente> restOutput = new RestOutput<Cliente>();
		
		try {
			clienteService.delete(restInput.getEntity());
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
