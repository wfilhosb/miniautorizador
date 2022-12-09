package com.miniautorizador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.miniautorizador.model.Transacoes;

@Repository
public interface TransacoesRepository extends CrudRepository<Transacoes, Long>{

}
