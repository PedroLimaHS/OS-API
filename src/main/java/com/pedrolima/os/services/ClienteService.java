package com.pedrolima.os.services;

import com.pedrolima.os.Repositories.OperacaoRepository;
import com.pedrolima.os.domain.Cliente;
import com.pedrolima.os.domain.Operacao;
import com.pedrolima.os.domain.Pessoa;
import com.pedrolima.os.dtos.ClienteDTO;
import com.pedrolima.os.services.exceptions.DataIntegratyViolationException;
import com.pedrolima.os.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private OperacaoRepository repository;


    public Operacao findById(Integer id) {
        Optional<Operacao> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "objeto não encontrado! " + id + ", tipo: " + Operacao.class.getName()));

    }

    public List<Operacao> findAll() {
        return repository.findAll();
    }

    public Operacao create(Operacao objDTO) {

        return repository.save(objDTO);
    }

    public Operacao update(Integer id, @Valid Operacao objDTO) {
         return repository.save(objDTO);
    }

    public void delete(Integer id){

        repository.deleteById(id);
    }


}
