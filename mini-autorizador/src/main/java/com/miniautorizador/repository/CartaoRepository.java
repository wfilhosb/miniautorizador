package com.miniautorizador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.miniautorizador.model.Cartao;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long>{

}
