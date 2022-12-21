package com.miniautorizador.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.miniautorizador.model.Cartao;
import com.miniautorizador.model.Mensagem;
import com.miniautorizador.model.Transacoes;
import com.miniautorizador.repository.CartaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Transactional
	public ResponseEntity<Mensagem> realizarTransacao(Transacoes transacao) {

		try {
			Optional<Cartao> cartaoDaTransacao = cartaoRepository.findById(transacao.getNumeroCartaoTransacao());
			if (cartaoDaTransacao.get().getNumeroCartao() == transacao.getNumeroCartaoTransacao()
					&& cartaoDaTransacao.get().getSaldoCartao() >= transacao.getValorTransacao()
					&& cartaoDaTransacao.get().getSenhaCartao() == transacao.getSenhaCartaoTransacao()) {
				cartaoDaTransacao.get().setSaldoCartao(cartaoDaTransacao.get().getSaldoCartao() - transacao.getValorTransacao());
				cartaoRepository.save(cartaoDaTransacao.get());
				return new ResponseEntity(new Mensagem("OK"), HttpStatus.valueOf(201));
			} else if (cartaoDaTransacao.get().getSaldoCartao() < transacao.getValorTransacao()) {
				return new ResponseEntity(new Mensagem("SALDO_INSUFICIENTE"), HttpStatus.valueOf(422));
			} else {
				return new ResponseEntity(new Mensagem("SENHA_INVALIDA"), HttpStatus.valueOf(422));
			}
		} catch (Exception e) {
			return new ResponseEntity(new Mensagem("CARTAO_INEXISTENTE"), HttpStatus.valueOf(422));
		}
	}
	
}
