package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany()
    public List<Aluno> alunos = new ArrayList<Aluno>();

    @OneToMany()
    public List<Professor> professores = new ArrayList<Professor>();


}
