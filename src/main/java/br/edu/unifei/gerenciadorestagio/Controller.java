package br.edu.unifei.gerenciadorestagio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    public final RepoInstituto institutos;
    public final RepoCoordenador coordenadores;
    public final RepoCurso cursos;

    Controller(
        RepoInstituto institutos,
        RepoCoordenador coordenadores,
        RepoCurso cursos
    ) {
        this.institutos = institutos;
        this.coordenadores = coordenadores;
        this.cursos = cursos;
    }


    /**
     * INSTITUTOS
     */

    @PostMapping("instituto/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Instituto AdicionarInstituto(@RequestBody Instituto instituto) {
        institutos.save(instituto);
        return instituto;
    }

    @GetMapping("instituto/get")
    @ResponseStatus(HttpStatus.OK)
    public Iterable Institutos() {
        return institutos.findAll();
    }

    /**
     * CURSOS
     */

    @PostMapping("curso/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso AdicionarCurso(@RequestBody Curso curso) {
        cursos.save(curso);
        return curso;
    }
}
