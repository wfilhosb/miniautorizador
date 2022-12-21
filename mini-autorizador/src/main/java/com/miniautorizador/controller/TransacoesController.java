package com.miniautorizador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniautorizador.model.Mensagem;
import com.miniautorizador.model.Transacoes;
import com.miniautorizador.service.TransacaoService;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacoesController {

	@Autowired
	private TransacaoService transacoesService;

	@PostMapping
	public ResponseEntity<Mensagem> realizarTransacao(@RequestBody Transacoes transacao) {
		ResponseEntity<Mensagem> transacaoRealizada = transacoesService.realizarTransacao(transacao);
		return transacaoRealizada;
	}
	
}
