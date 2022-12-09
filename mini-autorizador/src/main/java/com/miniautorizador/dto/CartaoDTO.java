package com.miniautorizador.dto;

import com.miniautorizador.model.Cartao;

public class CartaoDTO{
	
	private int senha;
	private Long numeroCartao;
	
	public CartaoDTO (Cartao cartao) {
		this.senha = cartao.getSenhaCartao();
		this.numeroCartao = cartao.getNumeroCartao();
	}
	
	public int getSenha() {
		return senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

}
