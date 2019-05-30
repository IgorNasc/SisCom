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

import com.sis.com.business.model.Produto;
import com.sis.com.business.service.ProdutoService;
import com.sis.com.system.SisComException;

@CrossOrigin
@RestController
@RequestMapping("/produto")
public class ProdutoRestController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/findAll")
	public RestOutput<Produto> findAllFornecedor(){
		RestOutput<Produto> restOutput = new RestOutput<Produto>();
		
		try {
			restOutput.setListEntity(produtoService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restOutput;
	}
	
	@GetMapping("/findEstoqueLessThenMinimo")
	public RestOutput<Produto> findEstoqueLessThenMinimo(){
		RestOutput<Produto> restOutput = new RestOutput<Produto>();
		
		try {
			restOutput.setListEntity(produtoService.findEstoqueLessThenMinimo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restOutput;
	}

	@PostMapping("/cadastrar")
	public RestOutput<Produto> cadastrarProduto(@RequestBody RestInput<Produto> restInput){
		RestOutput<Produto> restOutput = new RestOutput<Produto>();
		
		try {
			produtoService.cadastrar(restInput.getEntity());
			restOutput.setStatus(201);
		} catch (SisComException e) {
			restOutput.addWarn(e.getMenssagemErro());
			restOutput.setStatus(409);
		}  catch (Exception e) {
			restOutput.setStatus(500);
		}
		
		return restOutput;
	}

	@DeleteMapping("/delete/{codigo}")
	public RestOutput<Produto> deletarProduto(@PathVariable("codigo") Long codigo){
		RestOutput<Produto> restOutput = new RestOutput<Produto>();
		
		try {
			produtoService.deletar(codigo);
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
