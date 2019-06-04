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

import com.sis.com.business.model.Venda;
import com.sis.com.business.service.VendaService;
import com.sis.com.system.SisComException;

@CrossOrigin
@RestController
@RequestMapping("/venda")
public class VendaRestController {
	@Autowired
	private VendaService vendaService;
	
	@GetMapping("/findAll")
	public RestOutput<Venda> findAllVendas(){
		RestOutput<Venda> restOutput = new RestOutput<Venda>();
		
		try {
			restOutput.setListEntity(vendaService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restOutput;
	}

	@PostMapping("/cadastrar")
	public RestOutput<Venda> cadastrarVenda(@RequestBody RestInput<Venda> restInput){
		
		RestOutput<Venda> restOutput = new RestOutput<Venda>();
		
		try {
			vendaService.cadastrar(restInput.getEntity());
			restOutput.setStatus(201);
		} catch (SisComException e) {
			restOutput.addWarn(e.getMenssagemErro());
			restOutput.setStatus(409);
		}  catch (Exception e) {
			e.printStackTrace();
			restOutput.setStatus(500);
		}
		
		return restOutput;
	}

	@DeleteMapping("/delete/{codigo}")
	public RestOutput<Venda> excluirVenda(@PathVariable("codigo") Long codigo){
		
		RestOutput<Venda> restOutput = new RestOutput<Venda>();
		
		try {
			vendaService.excluir(codigo);
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
