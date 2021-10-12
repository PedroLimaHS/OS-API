package com.pedrolima.os.resources;

import com.pedrolima.os.domain.Tecnico;
import com.pedrolima.os.dtos.TecnicoDTO;
import com.pedrolima.os.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")// endpoint inicial para acessar a classe
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findbyId(@PathVariable Integer id) {
        //Tecnico obj = service.findById(id);
        TecnicoDTO objDTO = new TecnicoDTO(service.findById(id));//obj
        return ResponseEntity.ok().body(objDTO);
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {

        List<TecnicoDTO> listDTO = service.findAll().stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
//        List<Tecnico> list = service.findAll();
//        List<TecnicoDTO> listDTO = new ArrayList<>();
//
//                for(Tecnico obj : list){
//                    listDTO.add(new TecnicoDTO(obj));
//                }
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid/*valida os campos do DTO*/ @RequestBody TecnicoDTO objDTO) {
        Tecnico newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO objDTO) {
        TecnicoDTO newObj = new TecnicoDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
