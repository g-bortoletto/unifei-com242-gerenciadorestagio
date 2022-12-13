package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName="id")
    public MEndereco endereco;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instituto_id", referencedColumnName="id")
    @JsonBackReference
    public MInstituto instituto;

    @OneToMany(mappedBy = "professor")
    @JsonManagedReference
    public List<MAluno> alunos ;

    @OneToMany(mappedBy = "professor")
    @JsonManagedReference
    public List<MInfoEstagio> infoEstagios ;

}
