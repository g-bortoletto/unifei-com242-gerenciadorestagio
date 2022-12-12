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

    public String nome;
    public String sigla;

    @OneToMany()
    public List<MCurso> cursos = new ArrayList<MCurso>();

    @OneToMany(mappedBy = "instituto")
    @JsonManagedReference
    public List<MProfessor> professores ;
}
