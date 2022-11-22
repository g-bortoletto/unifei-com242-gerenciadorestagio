package br.edu.unifei.gerenciadorestagio.models;

import javax.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(unique = true)
    public String codigo;

    @Column(unique = true)
    public String nome;

    public Periodo periodo;
}
