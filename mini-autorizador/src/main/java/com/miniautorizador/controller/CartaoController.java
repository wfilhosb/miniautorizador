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
import com.miniautorizador.dto.CartaoDTO;
import com.miniautorizador.dto.SaldoDTO;
import com.miniautorizador.model.Cartao;
import com.miniautorizador.repository.CartaoRepository;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoController {

	@Autowired
	private CartaoRepository cartaoRepository;

	// CRIAR NOVO CARTAO
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<CartaoDTO> criarNovo(@RequestBody Cartao cartao) {
			cartao.setSaldoCartao(500);
			Cartao cartaoCriado = cartaoRepository.save(cartao);
			CartaoDTO cartaoDTO = new CartaoDTO(cartaoCriado);
			return new ResponseEntity<CartaoDTO>(cartaoDTO, HttpStatusCode.valueOf(201)); // CRIAÇÃO COM SUCESSO STATUS CODE 201
	}

	// RETORNA SALDO
	@GetMapping(value = "/{numeroCartao}")
	public ResponseEntity<SaldoDTO> saldoCartao(@PathVariable(value = "numeroCartao") Long numeroCartao) {
		try {
			Optional<Cartao> cartao = cartaoRepository.findById(numeroCartao);
			SaldoDTO saldoDTO = new SaldoDTO(cartao.get());
			return new ResponseEntity<SaldoDTO>(saldoDTO, HttpStatusCode.valueOf(200)); // BUSCA DO SALDO COM SUCESSO STATUS 200																		// CODE 200
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<SaldoDTO>(HttpStatusCode.valueOf(404)); //CASO NÃO EXISTA STATUS CODE 404
		}
		
	}

	// REALIZA UMA TRANSAÇÃO
	@PostMapping(value = "/transacoes")
	public ResponseEntity<Cartao> realizaTransacao(@RequestBody Cartao cartao) {
		Cartao cartaoDaTransacao = cartaoRepository.save(cartao);
		return new ResponseEntity<Cartao>(cartaoDaTransacao, HttpStatusCode.valueOf(201));
	}

}
