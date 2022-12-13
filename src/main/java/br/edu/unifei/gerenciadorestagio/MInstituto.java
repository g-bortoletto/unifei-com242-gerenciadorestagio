package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MInstituto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true, nullable = false)
    public String nome;
    @Column(unique = true, nullable = false)
    public String sigla;


    @OneToMany(mappedBy = "instituto")
    @JsonManagedReference
    public List<MCurso> cursos ;

    @OneToMany(mappedBy = "instituto")
    @JsonManagedReference
    public List<MProfessor> professores ;

    @OneToMany(mappedBy = "instituto")
    @JsonManagedReference
    public List<MInfoEstagio> projetos ;
}
