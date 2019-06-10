package com.sis.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.com.business.model.RelatorioDto;
import com.sis.com.business.service.RelatorioService;

@CrossOrigin
@RestController
@RequestMapping("/relatorio")
public class RelatorioRestController {

	@Autowired
	private RelatorioService relatorioService;
	
	@GetMapping("/venda/vendedor")
	public RestOutput<RelatorioDto> relatorioVendaVendedor() {
		RestOutput<RelatorioDto> restOutput = new RestOutput<RelatorioDto>();
		
		try {
			restOutput.setListEntity(relatorioService.relatorioVendaVendedor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restOutput;
	}
	
	@GetMapping("/venda/cliente")
	public RestOutput<RelatorioDto> relatorioVendaCliente() {
		RestOutput<RelatorioDto> restOutput = new RestOutput<RelatorioDto>();
		
		try {
			restOutput.setListEntity(relatorioService.relatorioVendaCliente());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restOutput;
	}
	
	@GetMapping("/compra/fornecedor")
	public RestOutput<RelatorioDto> relatorioCompraFornecedor() {
		RestOutput<RelatorioDto> restOutput = new RestOutput<RelatorioDto>();
		
		try {
			restOutput.setListEntity(relatorioService.relatorioCompraFornecedor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restOutput;
	}
}
