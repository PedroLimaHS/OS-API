package com.pedrolima.os.Repositories;

import com.pedrolima.os.domain.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface OsRepository extends JpaRepository<OS,Integer > {// a clase de onde ele estende e o tipo primitivo do objeto identificador/id
}
