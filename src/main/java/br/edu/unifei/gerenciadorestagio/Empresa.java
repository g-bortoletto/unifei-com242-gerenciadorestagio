package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false)
    public String razao_social;

    public String atividade_principal;

    public String tipo_empresa;

    @OneToOne(cascade = CascadeType.ALL)
    public Endereco endereco;
}
