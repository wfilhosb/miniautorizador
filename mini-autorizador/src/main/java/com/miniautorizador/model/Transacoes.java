package com.miniautorizador.model;

import java.io.Serializable;
import java.util.Objects;


public class Transacoes implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Long numeroCartao;
	private int senhaCartao;
	private double valor;

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public int getSenhaCartao() {
		return senhaCartao;
	}

	public void setSenhaCartao(int senhaCartao) {
		this.senhaCartao = senhaCartao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCartao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacoes other = (Transacoes) obj;
		return Objects.equals(numeroCartao, other.numeroCartao);
	}

}
