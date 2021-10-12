package com.pedrolima.os.Repositories;

import com.pedrolima.os.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> /*a clase de onde ele estende e o tipo primitivo da chave primaria/id*/{



}
