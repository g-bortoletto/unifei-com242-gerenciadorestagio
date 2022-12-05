package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MInfoEstagio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @OneToOne(cascade = CascadeType.ALL)
    public MEmpresa empresa;

    @OneToOne(cascade = CascadeType.ALL)
    public MAluno aluno;

    @OneToOne(cascade = CascadeType.ALL)
    public MProfessor professor;

    public Integer semestre;

    public Integer cargaExigida;

    public Date dataInicio;

    public Date dataPrevistoTermino;

    public String nomeOrientador;

    public String formacaoOrientador;

    public String cargoOrientador;

    public String emailOrientador;

    public String telefoneOrientador;

    public String localEstagio;

    public Integer diasTrabalhoSemanal;

    public Integer cargaDiaria;

    public String projetoRelacionado;

    public String tipoBolsa;

    public Number valorBolsa;

    public String descricaoAntividade;

    public String definicaoCronograma;

    public String descricaoResultados;

    public String descricaoMeios;

    public String descricaoDisciplinas;

}
