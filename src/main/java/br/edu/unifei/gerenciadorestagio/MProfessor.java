package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MProfessor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false )
    public String nome;

    @Column(unique = true)
    public String cpf;

    @Column(unique = true)
    public String rg;

    @Column(unique = true)
    public String matricula;

    public ECampus ECampus;

    public String telefone;

    @Column(nullable = false )
    public String email;

    @Column(nullable = false)
    public Integer endereco_id;


    @OneToMany(cascade = CascadeType.ALL)
    public List<MAluno> mAlunos = new ArrayList<MAluno>();

}
