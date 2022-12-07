package com.miniautorizador.repository;

import org.springframework.data.repository.CrudRepository;

import com.miniautorizador.model.Transacoes;

public interface TransacoesRepository extends CrudRepository<Transacoes, Long>{

}
