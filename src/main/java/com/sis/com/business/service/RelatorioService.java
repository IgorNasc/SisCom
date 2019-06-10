package com.sis.com.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.RelatorioDto;
import com.sis.com.repository.RelatorioRepository;

@Service
public class RelatorioService {
	
	@Autowired
	private RelatorioRepository relatorioRepository;
	
	public List<RelatorioDto> relatorioVendaVendedor(){
		return relatorioRepository.relatorioVendaVendedor();
	}
	
	public List<RelatorioDto> relatorioVendaCliente(){
		return relatorioRepository.relatorioVendaCliente();
	}
	
	public List<RelatorioDto> relatorioCompraFornecedor(){
		return relatorioRepository.relatorioCompraFornecedor();
	}
}
