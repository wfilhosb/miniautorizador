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
	private TransacoesRepository transacoesRepository;

	@Autowired
	private CartaoRepository cartaoRepository;

	@PostMapping(value = "/", produces = "apllication/json")
	public ResponseEntity<Transacoes> realizarTransacao(@RequestBody Transacoes transacao) {

		try {
			Optional<Cartao> cartaoDaTransacao = cartaoRepository.findById(transacao.getNumeroCartaoTransacao());
			if (cartaoDaTransacao.get().getNumeroCartao() == transacao.getNumeroCartaoTransacao()
					&& cartaoDaTransacao.get().getSaldoCartao() >= transacao.getValorTransacao()
					&& cartaoDaTransacao.get().getSenhaCartao() == transacao.getSenhaCartaoTransacao()) {
				cartaoDaTransacao.get().setSaldoCartao(cartaoDaTransacao.get().getSaldoCartao() - transacao.getValorTransacao());
				cartaoRepository.save(cartaoDaTransacao.get());
				return new ResponseEntity("OK", HttpStatusCode.valueOf(201));
			} else if (cartaoDaTransacao.get().getSaldoCartao() < transacao.getValorTransacao()) {
				return new ResponseEntity("SALDO_INSUFICIENTE", HttpStatusCode.valueOf(422));
			} else {
				return new ResponseEntity("SENHA_INVALIDA", HttpStatusCode.valueOf(422));
			}
		} catch (Exception e) {
			return new ResponseEntity("CARTAO_INEXISTENTE", HttpStatusCode.valueOf(422));
		}
	}
}
