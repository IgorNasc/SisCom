package com.sis.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.com.business.model.Vendedor;
import com.sis.com.business.service.VendedorService;
import com.sis.com.system.SisComException;

@CrossOrigin
@RestController
@RequestMapping("/vendedor")
public class VendedorRestController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping("/findAll")
	public RestOutput<Vendedor> findAllVendedor(){
		RestOutput<Vendedor> restOutput = new RestOutput<Vendedor>();
		
		try {
			restOutput.setListEntity(vendedorService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restOutput;
	}
	
	@PostMapping("/cadastrar")
	public RestOutput<Vendedor> cadastrarVendedor(@RequestBody RestInput<Vendedor> restInput){
		RestOutput<Vendedor> restOutput = new RestOutput<Vendedor>();
		
		try {
			vendedorService.cadastrarVendedor(restInput.getEntity());
			
			restOutput.setStatus(200);
		} catch (SisComException e) {
			restOutput.addWarn(e.getMenssagemErro());
			restOutput.setStatus(409);
		} catch (Exception e) {
			e.printStackTrace();
			restOutput.setStatus(500);
		}
		
		return restOutput;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public RestOutput<Vendedor> deleteVendedor(@PathVariable("codigo") Long codigo){
		RestOutput<Vendedor> restOutput = new RestOutput<Vendedor>();
		
		try {
			vendedorService.delete(codigo);
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
