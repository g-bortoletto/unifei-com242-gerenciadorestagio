package br.edu.unifei.gerenciadorestagio.controllers;

import br.edu.unifei.gerenciadorestagio.models.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstitutoController {
    public final InstitutoRepository repository;

    InstitutoController(InstitutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("instituto/add")
    public void AdicionarInstituto(@RequestBody Instituto instituto) {

    }
}
