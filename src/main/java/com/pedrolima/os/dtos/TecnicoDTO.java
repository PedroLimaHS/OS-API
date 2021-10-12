package com.pedrolima.os.dtos;

import com.pedrolima.os.domain.Tecnico;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

public class TecnicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "O campo nome é requerido")
    private String nome;
    @CPF
    @NotEmpty(message = "O campo cpf é requerido")
    private String cpf;
    @NotEmpty(message = "O campo telefone é requerido")
    private String telefone;

    public TecnicoDTO() {
        super();
    }

    public TecnicoDTO(Tecnico obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.telefone = obj.getTelefone();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TecnicoDTO that = (TecnicoDTO) o;
        return (id.equals(that.id) && nome.equals(that.nome) && cpf.equals(that.cpf) && telefone.equals(that.telefone));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, telefone);
    }
}
