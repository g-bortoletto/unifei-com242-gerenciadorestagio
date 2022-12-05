package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;

@Entity
public class Coordenador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false)
    public String nome;

    @Column(unique = true)
    public String cpf;

    @Column(unique = true)
    public String rg;

    public Campus campus;
    public String email;
    public String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    public Instituto instituto;
    public String senha;

    @OneToOne(cascade = CascadeType.ALL)
    public Endereco endereco;
}
