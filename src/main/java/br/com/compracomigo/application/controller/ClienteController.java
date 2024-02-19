package br.com.compracomigo.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compracomigo.domain.model.Cliente;
import br.com.compracomigo.domain.model.ClientePesquisaModel;
import br.com.compracomigo.domain.services.CustormerService;
import br.com.compracomigo.domain.services.PesquisaClienteService;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	@Autowired
	CustormerService service;
	
	@Autowired
	PesquisaClienteService clienteService;
	
	@PostMapping("/novo")
	public ResponseEntity<Cliente> novoCliente(@RequestBody Cliente customer) throws Exception {
		customer = service.newCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}
	
	@GetMapping("/uuid/{uuid}")
	public ResponseEntity<ClientePesquisaModel> buscarCliente(@PathVariable String uuid) throws Exception {
		var cliente = clienteService.pesquisarClientePorDocumento(uuid);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
}
