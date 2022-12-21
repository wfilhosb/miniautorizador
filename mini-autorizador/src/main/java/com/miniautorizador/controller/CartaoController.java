package com.miniautorizador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miniautorizador.dto.CartaoDTO;
import com.miniautorizador.dto.SaldoDTO;
import com.miniautorizador.model.Cartao;
import com.miniautorizador.service.CartaoService;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoController {

	@Autowired
	private CartaoService cartaoService;

	@PostMapping
	public ResponseEntity<CartaoDTO> criarNovo(@RequestBody Cartao cartao) {
		ResponseEntity<CartaoDTO> cartaoDTO = cartaoService.criarNovo(cartao);
		return cartaoDTO;

	}

	@GetMapping(value = "/{numeroCartao}")
	public ResponseEntity<SaldoDTO> saldoCartao(@PathVariable(value = "numeroCartao") Long numeroCartao) {
		ResponseEntity<SaldoDTO> saldoDTO = cartaoService.saldoCartao(numeroCartao);
		return saldoDTO;
	}

}
