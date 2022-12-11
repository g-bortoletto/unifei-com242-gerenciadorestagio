package br.edu.unifei.gerenciadorestagio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    public final IRInstituto m_institutos;
    public final IRCoordenador m_coordenadores;
    public final IRCurso m_cursos;
    public final IRAluno m_alunos;
    public final IREmpresa m_empresas;
    public final IRProfessor m_professores;

    Controller(
        IRInstituto m_institutos,
        IRCoordenador m_coordenadores,
        IRCurso m_cursos,
        IRAluno m_alunos,
        IREmpresa m_empresas,
        IRProfessor m_professores) {
        this.m_institutos = m_institutos;
        this.m_coordenadores = m_coordenadores;
        this.m_cursos = m_cursos;
        this.m_alunos = m_alunos;
        this.m_empresas = m_empresas;
        this.m_professores = m_professores;
    }


    /**
     * INSTITUTOS
     */

    @PostMapping("instituto/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MInstituto adicionarInstituto(@RequestBody MInstituto instituto) {
        m_institutos.save(instituto);
        return instituto;
    }

    @GetMapping("institutos")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable institutos() {
        return m_institutos.findAll();
    }

    /**
     * CURSOS
     */

    @PostMapping("curso/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MCurso adicionarCurso(@RequestBody MCurso curso) {
        m_cursos.save(curso);
        return curso;
    }

    /**
     * ALUNOS
     */

    @PostMapping("alunos/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MAluno adicionarAluno(@RequestBody MAluno aluno) {
        m_alunos.save(aluno);
        return aluno;
    }

    @GetMapping("alunos")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MAluno> alunos(@RequestParam(required = false) Long id) {
        List<MAluno> resultado = new ArrayList<>();

        if (id == null) {
            var listaAlunos = m_alunos.findAll();
            for (var aluno : listaAlunos) {
                resultado.add(aluno);
            }
        } else {
            if (m_alunos.existsById(id))
            {
                resultado.add(m_alunos.findById(id).get());
            }
        }

        return resultado;
    }


}