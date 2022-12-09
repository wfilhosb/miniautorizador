package com.miniautorizador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniautorizador.model.Cartao;
import com.miniautorizador.model.Transacoes;
import com.miniautorizador.repository.CartaoRepository;
import com.miniautorizador.repository.TransacoesRepository;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacoesController {
	
	@Autowired(required = false)
	private TransacoesRepository transacoesRepository;//requer um bean do tipo TransacoesRepository
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@PostMapping(value = "/", produces = "apllication/json")
	public ResponseEntity<Transacoes> realizarTransacao(@RequestBody Transacoes transacao){
		Optional<Cartao> cartaoDaTransacao = cartaoRepository.findById(transacao.getNumeroCartaoTransacao());
		System.out.println(cartaoDaTransacao.get().getSenhaCartao());
		System.out.println(cartaoDaTransacao.get().getSaldoCartao());
		System.out.println("-----------------");
		System.out.println(transacao.getValorTransacao());
		
		return new ResponseEntity<Transacoes>(HttpStatusCode.valueOf(201));
	}
}
