package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;

@Entity
public class Coordenador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(unique = true)
    public String nome;

    @Column(unique = true)
    public String cpf;

    @Column(unique = true)
    public String rg;

    public Campus campus;
    public String email;
    public String telefone;
    public int instituto_id;
    public String senha;
}
