package com.sis.com.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.com.business.model.Cliente;
import com.sis.com.repository.ClienteRepository;
import com.sis.com.system.SisComException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void cadastrarCliente(Cliente cliente) throws SisComException {
		Cliente verificaCliente = clienteRepository.FindByCpf(cliente.getCpf());
		
		if(verificaCliente != null) {
			throw new SisComException("Este cliente com o cpf: "+ cliente.getCpf() +", já está cadastrado!");
		}
		
		clienteRepository.save(cliente);
	}
}
