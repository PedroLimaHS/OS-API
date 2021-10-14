package com.pedrolima.os.services;

import com.pedrolima.os.Repositories.ClienteRepository;
import com.pedrolima.os.domain.Cliente;
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
    private ClienteRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "objeto não encontrado! " + id + ", tipo: " + Cliente.class.getName()));

    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        if (findByCPF(objDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado!");
        }
        return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        //verificar se existe
        Cliente oldObj = findById(id);
        if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
            throw new DataIntegratyViolationException("CPF já cadastrado!");
        }
        oldObj.setNome(objDTO.getNome());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setTelefone(objDTO.getTelefone());
        return repository.save(oldObj);
    }

    public void delete(Integer id){
        Cliente obj = findById(id);

        if (obj.getList().size()>0){//verifica se tem ordem de serviço
            throw new DataIntegratyViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    private Pessoa findByCPF(ClienteDTO objDTO) {
        Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }
}
