package com.miniautorizador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.miniautorizador.dto.CartaoDTO;
import com.miniautorizador.dto.SaldoDTO;
import com.miniautorizador.model.Cartao;
import com.miniautorizador.repository.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Transactional
	public ResponseEntity<CartaoDTO> criarNovo(Cartao cartao) {
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
	
	@Transactional
	public ResponseEntity<SaldoDTO> saldoCartao(Long numeroCartao) {
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
