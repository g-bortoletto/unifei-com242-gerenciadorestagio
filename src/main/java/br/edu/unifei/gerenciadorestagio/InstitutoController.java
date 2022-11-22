package br.edu.unifei.gerenciadorestagio;

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
    public Instituto AdicionarInstituto(@RequestBody Instituto instituto) {
        repository.save(instituto);
        return instituto;
    }
}
