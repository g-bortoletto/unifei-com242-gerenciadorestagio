package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    public ECampus campus;

    public String telefone;

    @Column(nullable = false )
    public String email;

    @Column(nullable = false)
    public Integer enderecoId;

    public String instituto;

//    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public  List<MCurso> cursos = new ArrayList<>();
//    @ManyToOne()
//    @JsonBackReference
//    public  MCurso curso;
//

    @OneToMany(cascade = CascadeType.ALL)
    public List<MAluno> alunos = new ArrayList<MAluno>();

}
