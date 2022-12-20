package com.miniautorizador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miniautorizador.model.Transacoes;
import com.miniautorizador.service.TransacaoService;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacoesController {

	@Autowired
	private TransacaoService transacoesService;

	@PostMapping(value = "/", produces = "apllication/json")
	public ResponseEntity<Transacoes> realizarTransacao(@RequestBody Transacoes transacao) {
		ResponseEntity<Transacoes> transacaoRealizada = transacoesService.realizarTransacao(transacao);
		return transacaoRealizada;
	}
	
}
