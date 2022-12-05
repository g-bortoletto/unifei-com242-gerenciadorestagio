package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(unique = true)
    public String codigo;

    @Column(unique = true)
    public String nome;

    public EPeriodo periodo;

    @OneToMany()
    public List<MAluno> alunos = new ArrayList<MAluno>();

    @OneToMany()
    public List<MProfessor> professores = new ArrayList<MProfessor>();


}
