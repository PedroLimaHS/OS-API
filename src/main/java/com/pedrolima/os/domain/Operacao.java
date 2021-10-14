package com.pedrolima.os.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "operacoes")
@Getter
@Setter
public class Operacao {
    @Id
    @SequenceGenerator( name = "SEQ", sequenceName = "GEN_operacoes_ID", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ" )
    @Column(name = "operacao")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "dgagencia")
    private String dgagencia;
    @Column(name = "ccorrente")
    private String ccorrente;
    @Column(name = "dgccorrente")
    private String dgccorrente;
    @Column(name = "nossonumero")
    private String nossonumero;
    @Column(name = "convenio")
    private String convenio;
    @Column(name = "carteira")
    private String carteira;
    @Column(name = "seqcnab")
    private String seqcnab;

}
