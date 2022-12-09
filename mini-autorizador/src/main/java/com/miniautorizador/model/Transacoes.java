package com.miniautorizador.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Transacoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long numeroCartaoTransacao;
	private String senhaCartaoTransacao;
	private double valorTransacao;

	public Long getNumeroCartaoTransacao() {
		return numeroCartaoTransacao;
	}

	public void setNumeroCartaoTransacao(Long numeroCartaoTransacao) {
		this.numeroCartaoTransacao = numeroCartaoTransacao;
	}

	public String getSenhaCartaoTransacao() {
		return senhaCartaoTransacao;
	}

	public void setSenhaCartaoTransacao(String senhaCartaoTransacao) {
		this.senhaCartaoTransacao = senhaCartaoTransacao;
	}

	public double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCartaoTransacao);
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
		return Objects.equals(numeroCartaoTransacao, other.numeroCartaoTransacao);
	}

}
