package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
public class Info_estagio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @OneToOne(cascade = CascadeType.ALL)
    public Empresa empresa;

    @OneToOne(cascade = CascadeType.ALL)
    public Aluno aluno;

    @OneToOne(cascade = CascadeType.ALL)
    public Professor professor;

    public Integer semestre;

    public Integer carga_exigida;

    public Date data_inicio;

    public Date data_previsto_termino;

    public String nome_orientador;

    public String formacao_orientador;

    public String cargo_orientador;

    public String email_orientador;

    public String telefone_orientador;

    public String local_estagio;

    public Integer dias_trabalho_semanal;

    public Integer carga_diaria;

    public String projeto_relacionado;

    public String tipo_bolsa;

    public Number valor_bolsa;

    public String descricao_antividade;

    public String definicao_cronograma;

    public String descricao_resultados;

    public String descricao_meios;

    public String descricao_disciplinas;

}
