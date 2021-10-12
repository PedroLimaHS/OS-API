package com.pedrolima.os.Repositories;

import com.pedrolima.os.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface ClienteRepository extends JpaRepository<Cliente,Integer > {// a clase de onde ele estende e o tipo primitivo do objeto identificador/id
}
