package com.miniautorizador.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.miniautorizador.model.Cartao;
import com.miniautorizador.model.Transacoes;
import com.miniautorizador.repository.CartaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Transactional
	public ResponseEntity<Transacoes> realizarTransacao(Transacoes transacao) {

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
