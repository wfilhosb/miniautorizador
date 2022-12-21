package com.miniautorizador.model;

public class Mensagem {
	private String conteudoMensagem;

	public Mensagem(String conteudoMensagem) {
		this.conteudoMensagem = conteudoMensagem;
	}
	
	public Mensagem() {
		
	}
	
	public String getConteudoMensagem() {
		return conteudoMensagem;
	}

	public void setConteudoMensagem(String conteudoMensagem) {
		this.conteudoMensagem = conteudoMensagem;
	}
	
}
