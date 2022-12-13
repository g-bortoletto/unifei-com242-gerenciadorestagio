package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

//    @OneToMany()
//    public List<MAluno> alunos = new ArrayList<MAluno>();
    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    public List<MAluno> alunos ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instituto_id", referencedColumnName="id")
    @JsonBackReference
    public MInstituto instituto;


}
