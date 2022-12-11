package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;

@Entity
public class MAluno {
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

    @Column(nullable = false )
    public String curso;

    public ECampus campus;

    public String telefone;

    @Column(nullable = false )
    public String email;

    @Column(nullable = false)
    public Long professorId;

    @Column(nullable = false)
    public Long enderecoId;

    @Column(nullable = false)
    public Long cursoId;

}
