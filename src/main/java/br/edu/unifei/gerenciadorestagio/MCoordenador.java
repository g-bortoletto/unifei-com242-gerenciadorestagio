package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;

@Entity
public class MCoordenador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false)
    public String nome;

    @Column(unique = true)
    public String cpf;

    @Column(unique = true)
    public String rg;

    public ECampus ECampus;
    public String email;
    public String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    public MInstituto mInstituto;
    public String senha;

    @OneToOne(cascade = CascadeType.ALL)
    public MEndereco mEndereco;
}