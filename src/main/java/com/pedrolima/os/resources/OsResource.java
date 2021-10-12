package com.pedrolima.os.resources;

import com.pedrolima.os.domain.Cliente;
import com.pedrolima.os.dtos.ClienteDTO;
import com.pedrolima.os.dtos.OSDTO;
import com.pedrolima.os.services.ClienteService;
import com.pedrolima.os.services.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/os")
public class OsResource {

    @Autowired
    private OsService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OSDTO> findById(@PathVariable Integer id) throws IllegalAccessException {
        OSDTO obj = new OSDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<OSDTO>> findAll() {
        List<OSDTO> list = service.findAll().stream().map(obj -> new OSDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<OSDTO> create(@Valid @RequestBody OSDTO obj) throws IllegalAccessException {
        obj = new OSDTO(service.create(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getClass()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<OSDTO> update(@Valid @RequestBody OSDTO obj) throws IllegalAccessException {
        obj = new OSDTO(service.update(obj));
        return ResponseEntity.ok().body(obj);
    }
}