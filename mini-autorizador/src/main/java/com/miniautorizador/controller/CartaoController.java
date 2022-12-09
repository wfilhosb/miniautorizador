package com.miniautorizador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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
import com.miniautorizador.repository.CartaoRepository;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoController {

	@Autowired
	private CartaoRepository cartaoRepository;

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<CartaoDTO> criarNovo(@RequestBody Cartao cartao) {
		if (cartaoRepository.existsById(cartao.getNumeroCartao())) {
			CartaoDTO cartaoDTO = new CartaoDTO(cartao);
			return new ResponseEntity<CartaoDTO>(cartaoDTO, HttpStatusCode.valueOf(422));
		} else {
			cartao.setSaldoCartao(500);
			Cartao cartaoCriado = cartaoRepository.save(cartao);
			CartaoDTO cartaoDTO = new CartaoDTO(cartaoCriado);
			return new ResponseEntity<CartaoDTO>(cartaoDTO, HttpStatusCode.valueOf(201));
		}

	}

	@GetMapping(value = "/{numeroCartao}")
	public ResponseEntity<SaldoDTO> saldoCartao(@PathVariable(value = "numeroCartao") Long numeroCartao) {
		try {
			Optional<Cartao> cartao = cartaoRepository.findById(numeroCartao);
			SaldoDTO saldoDTO = new SaldoDTO(cartao.get());
			return new ResponseEntity<SaldoDTO>(saldoDTO, HttpStatusCode.valueOf(200));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<SaldoDTO>(HttpStatusCode.valueOf(404));
		}

	}

}
