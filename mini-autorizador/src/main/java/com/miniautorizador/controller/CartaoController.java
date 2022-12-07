package com.miniautorizador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.miniautorizador.model.Cartao;
import com.miniautorizador.repository.CartaoRepository;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoController {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	//CRIAR NOVO CARTAO
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Cartao> criarNovo(@RequestBody Cartao cartao){
		cartao.setSaldoCartao(500);
		Cartao cartaoCriado = cartaoRepository.save(cartao);
		return new ResponseEntity<Cartao>(cartaoCriado,HttpStatusCode.valueOf(201));
	}
	
	//RETORNA SALDO
	@GetMapping(value = "/{numeroCartao}")
	public ResponseEntity<Cartao> saldoCartao(@PathVariable(value = "numeroCartao") Long numeroCartao){
		Optional<Cartao> cartao = cartaoRepository.findById(numeroCartao);
		//return cartao.get().getSaldoCartao();
		return new ResponseEntity<Cartao>(cartao.get(), HttpStatus.OK);
	}
	
	//REALIZA UMA TRANSAÇÃO
	@PostMapping(value = "/transacoes")
	public ResponseEntity<Cartao> realizaTransacao(@RequestBody Cartao cartao){
		Cartao cartaoDaTransacao = cartaoRepository.save(cartao);
		return new ResponseEntity<Cartao>(cartaoDaTransacao,HttpStatusCode.valueOf(201));
	}
	
}
