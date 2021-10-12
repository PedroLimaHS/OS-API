package com.pedrolima.os.Repositories;

import com.pedrolima.os.domain.Pessoa;
import com.pedrolima.os.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("select  obj from Pessoa  obj where obj.cpf =:cpf")/*implementação da pesquisa de sem ja tem o cpf cadastrado*/
    Pessoa findByCPF(@Param("cpf") String cpf);
}
