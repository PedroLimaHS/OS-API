package com.pedrolima.os.services;

import com.pedrolima.os.Repositories.ClienteRepository;
import com.pedrolima.os.Repositories.OsRepository;
import com.pedrolima.os.Repositories.TecnicoRepository;
import com.pedrolima.os.domain.Cliente;
import com.pedrolima.os.domain.OS;
import com.pedrolima.os.domain.Tecnico;
import com.pedrolima.os.domain.enuns.Prioridade;
import com.pedrolima.os.domain.enuns.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private OsRepository osRepository;


    public void instanciaDb() {

        Tecnico t1 = new Tecnico(null, "Pedro", "084.999.594-90", "(81) 98852-2916");
        Cliente c1 = new Cliente(null, "Tomás", "084.999.594-90", "(81) 98832-2916");
        OS os1 = new OS(null, Prioridade.ALTA, "teste create ok", Status.ANDAMENTO, t1, c1);

        t1.getList().add(os1);
        c1.getList().add(os1);

        tecnicoRepository.saveAll(Arrays.asList(t1));
        clienteRepository.saveAll(Arrays.asList(c1));
        osRepository.saveAll(Arrays.asList(os1));

    }
}


