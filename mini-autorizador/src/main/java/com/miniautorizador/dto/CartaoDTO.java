package com.miniautorizador.dto;

import com.miniautorizador.model.Cartao;

public class CartaoDTO{
	
	private String senha;
	private Long numeroCartao;
	
	public CartaoDTO (Cartao cartao) {
		this.senha = cartao.getSenhaCartao();
		this.numeroCartao = cartao.getNumeroCartao();
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

}
