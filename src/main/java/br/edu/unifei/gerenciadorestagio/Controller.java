package br.edu.unifei.gerenciadorestagio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    public final IRInstituto institutos;
    public final IRCoordenador coordenadores;
    public final IRCurso cursos;

    Controller(
        IRInstituto institutos,
        IRCoordenador coordenadores,
        IRCurso cursos
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
    public MInstituto AdicionarInstituto(@RequestBody MInstituto mInstituto) {
        institutos.save(mInstituto);
        return mInstituto;
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
    public MCurso AdicionarCurso(@RequestBody MCurso mCurso) {
        cursos.save(mCurso);
        return mCurso;
    }
}
