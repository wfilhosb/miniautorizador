package com.miniautorizador.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.miniautorizador.model.Cartao;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long>{

}
