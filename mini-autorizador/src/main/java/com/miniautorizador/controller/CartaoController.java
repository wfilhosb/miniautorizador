package com.miniautorizador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miniautorizador.model.Cartao;
import com.miniautorizador.repository.CartaoRepository;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoController {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Cartao> criarNovo(@RequestBody Cartao cartao){
		cartao.setSaldoCartao(500);
		Cartao cartaoCriado = cartaoRepository.save(cartao);
		return new ResponseEntity<Cartao>(cartaoCriado,HttpStatus.OK);
	}
}
