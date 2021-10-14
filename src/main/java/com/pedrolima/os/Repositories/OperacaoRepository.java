package com.pedrolima.os.Repositories;


import com.pedrolima.os.domain.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface OperacaoRepository extends JpaRepository<Operacao,Integer > {// a clase de onde ele estende e o tipo primitivo do objeto identificador/id
}
