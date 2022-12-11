package br.edu.unifei.gerenciadorestagio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class Controller {

    public final IRInstituto institutos;
    public final IRCoordenador coordenadores;
    public final IRCurso cursos;
    public final IRAluno alunos;
    public final IREmpresa empresas;
    public final IRProfessor professores;
    Controller(
        IRInstituto institutos,
        IRCoordenador coordenadores,
        IRCurso cursos,
        IRAluno alunos,
        IREmpresa empresas,
        IRProfessor professores
    ) {
        this.institutos = institutos;
        this.coordenadores = coordenadores;
        this.cursos = cursos;
        this.alunos = alunos;
        this.empresas = empresas;
        this.professores = professores;
    }


    /**
     * INSTITUTOS
     */

    @PostMapping("instituto/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MInstituto AdicionarInstituto(@RequestBody MInstituto instituto) {
        institutos.save(instituto);
        return instituto;
    }

    @GetMapping("instituto/get")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable Institutos() {
        return institutos.findAll();
    }

    /**
     * CURSOS
     */

    @PostMapping("curso/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MCurso AdicionarCurso(@RequestBody MCurso curso) {
        cursos.save(curso);
        return curso;
    }

    /**
     * ALUNOS
     */

    @PostMapping("alunos/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MAluno AdicionarAluno(@RequestBody MAluno aluno) {
        alunos.save(aluno);
        return aluno;
    }

    @GetMapping("alunos/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable Alunos() {
        return alunos.findAll();
    }

    @GetMapping("alunos/groupByOrientador/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<MAluno> getById(@PathVariable long id) {

        Optional<MAluno> aluno = alunos.findById(id);
        if (aluno.isPresent()) {
            return new ResponseEntity<>(aluno.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

//
//    @GetMapping("estagio/aluno/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Re


}