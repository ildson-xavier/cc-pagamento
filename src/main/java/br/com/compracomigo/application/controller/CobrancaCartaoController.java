package br.com.compracomigo.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compracomigo.domain.model.CobrancaCartaoCreditoRequest;
import br.com.compracomigo.domain.model.CobrancaCartaoCreditoResponse;
import br.com.compracomigo.domain.services.CobrancaComCartaoCreditoService;

@RestController
@RequestMapping("/api/v1/cobranca-cartao-credito")
public class CobrancaCartaoController {

	@Autowired
	CobrancaComCartaoCreditoService cartaoCredito;
	
	@PostMapping
	public ResponseEntity<CobrancaCartaoCreditoResponse> cobrancaCartaoCredito(@RequestBody CobrancaCartaoCreditoRequest creditoRequest) throws Exception {
		var resp = cartaoCredito.cobrar(creditoRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
}
