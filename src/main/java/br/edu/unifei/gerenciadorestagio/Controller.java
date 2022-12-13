package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
    public final IRInfoEstagio m_infoEstagio;

    Controller(
        IRInstituto m_institutos,
        IRCoordenador m_coordenadores,
        IRCurso m_cursos,
        IRAluno m_alunos,
        IREmpresa m_empresas,
        IRProfessor m_professores,
        IRInfoEstagio m_infoEstagio )
        {
        this.m_institutos = m_institutos;
        this.m_coordenadores = m_coordenadores;
        this.m_cursos = m_cursos;
        this.m_alunos = m_alunos;
        this.m_empresas = m_empresas;
        this.m_professores = m_professores;
        this.m_infoEstagio = m_infoEstagio;
    }


    /**
     * INSTITUTOS

     * ROTAS - GET
     * /institutos - consultar todos institutos                          --  OK
     * /institutos/id - Consultar por um instituto especifico.           --  OK
     *
     * ROTAS - POST
     * /institutos/add - criar instituto                                 -- OK
     * */


    @PostMapping("instituto/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MInstituto adicionarInstituto(@RequestBody MInstituto instituto) {
        m_institutos.save(instituto);
        return instituto;
    }


    @GetMapping("institutos")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MInstituto> institutos(@RequestParam(required = false) String sigla) {
        List<MInstituto> resultado = new ArrayList<>();

        if (sigla == null) {
            var listaInstitutos = m_institutos.findAll();
            for (var institutos : listaInstitutos) {
                resultado.add(institutos);
            }
        } else {
            var listaInstitutos = m_institutos.findAll();
            for (var instituto : listaInstitutos) {
                System.out.println("charrrr");
                System.out.print(sigla);

                if (instituto.sigla.toUpperCase().matches(sigla.toUpperCase())  ) {
                    System.out.print(instituto);
                    resultado.add(instituto);
                }
            }
        }
        System.out.print(resultado);

        return resultado;
    }
    /**
     * CURSOS

     * ROTAS - GET
     * /cursos - consultar todos cursos                                     -- OK
     * /cursos/instituto/id - Consultar por um instituto especifico.        -- OK
     *
     * ROTAS - POST
     * /cursos/add - criar curso                                            -- OK
     * */

    @PostMapping("curso/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MCurso adicionarCurso(@RequestBody MCurso curso) {
        m_cursos.save(curso);
        return curso;
    }

    @GetMapping("cursos")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable cursos() {
        return m_cursos.findAll();
    }
    @GetMapping("cursos/instituto")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MCurso> cursosInstitutos(@RequestParam(required = true) String sigla) {
        List resultado = new ArrayList<>();

        m_institutos.findAll().forEach(mInstituto -> {
            System.out.print(mInstituto.cursos);
            if (mInstituto.sigla.toUpperCase().matches(sigla.toUpperCase())) {
                resultado.addAll(mInstituto.cursos);
            }
        });
//        for (var instituto : listaInstitutos) {
//            if (instituto.sigla.toUpperCase().matches(sigla.toUpperCase())  ) {
//                resultado = instituto.cursos;
//                System.out.println(resultado);
//            }
//        }
        return resultado;
    }

    /**
     * ALUNOS

     * ROTAS - GET
     * /alunos - consultar todos alunos                                     -- OK
     * /alunos/id - consultar aluno pelo id passado                         -- OK
     * /alunos/orientador/id - Consultar por um orientador especifico.      -- OK
     *
     * ROTAS - POST
     * /alunos/add - criar aluno                                            -- OK
     * */
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
    @GetMapping("alunos/orientador")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MAluno> alunosOrientador(@RequestParam(required = true) Long id) {
        List<MAluno> resultado = new ArrayList<>();

        var listaAlunos = m_alunos.findAll();
        for (var aluno : listaAlunos) {
            if (aluno.professor.id == id) {

                resultado.add(aluno);
            }
        }
        return resultado;
    }

    /**
     * PROFESSORES

     * ROTAS - GET
     * /professores - consultar todos professores                              --
     * /professores/id - consultar professor pelo id passado                   -- OK
     * /professores/instituto - Consultar por um instituto especifico.         -- OK
     *
     * ROTAS - POST
     * /professores/add - criar professor                                      -- OK
     * */
    @PostMapping("professores/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MProfessor adicionarProfessor(@RequestBody MProfessor professor) {
        m_professores.save(professor);
        return professor;
    }

    @GetMapping("professores")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MProfessor> professores(@RequestParam(required = false) Long id) {
        List<MProfessor> resultado = new ArrayList<>();

        if (id == null) {
            var listaProfessores = m_professores.findAll();
            for (var professor : listaProfessores) {
                resultado.add(professor);
            }
        } else {
            System.out.print("Teste");
            if (m_professores.existsById(id))
            {
                resultado.add(m_professores.findById(id).get());
            }
        }

        return resultado;
    }
    @GetMapping("professores/instituto")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MProfessor> professoresInstituto(@RequestParam(required = true) String sigla) {
        List<MProfessor> resultado = new ArrayList<>();

        m_institutos.findAll().forEach(instituto -> {
            if (instituto.sigla.toUpperCase().matches(sigla.toUpperCase())) {
                resultado.addAll(instituto.professores);
            }
        });
//        for (var professor : listaAlunos) {
//
//
//            if (professor.instituto != null && professor.instituto.toUpperCase().matches(sigla.toUpperCase())) {
//
//                resultado.add(professor);
//            }
//        }
        return resultado;
    }



    /**
     * PROJETOS

     * ROTAS - GET
     * /projetos - consultar todos projetos                                -- o
     * /projetos/aluno/id - consultar projetos por aluno                   --
     * /projetos/professores/id - consultar projetos por professor         --
     * /projetos/tipoPesquisa  - Consultar pelo tipo especifico.           -- Só tem o tipo estagio. nao implementado
     * /projetos/instituto  - Consultar pelo instituto                     -- OK
     *
     * ROTAS - POST
     * /projetos/add - criar projeto                                       -- OK
     * */

    @PostMapping("projetos/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MInfoEstagio adicionarProjeto(@RequestBody MInfoEstagio infoEstagio) {

        m_infoEstagio.save(infoEstagio);
        return infoEstagio;
    }

    @GetMapping("projetos")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MInfoEstagio> projetos(@RequestParam(required = false) Long id) {
        List<MInfoEstagio> resultado = new ArrayList<>();

        if (id == null) {
            var listaProjetos = m_infoEstagio.findAll();
            for (var projeto : listaProjetos) {
                resultado.add(projeto);
            }
        } else {
            if (m_infoEstagio.existsById(id))
            {
                resultado.add(m_infoEstagio.findById(id).get());
            }
        }

        return resultado;
    }

    @GetMapping("projetos/instituto")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MInfoEstagio> projetosInstituto(@RequestParam(required = true) String sigla) {
        List<MInfoEstagio> resultado = new ArrayList<>();

        m_institutos.findAll().forEach(instituto -> {
            if (instituto.sigla.toUpperCase().matches(sigla.toUpperCase())) {
                resultado.addAll(instituto.projetos);
            }
        });
//        for (var professor : listaAlunos) {
//
//
//            if (professor.instituto != null && professor.instituto.toUpperCase().matches(sigla.toUpperCase())) {
//
//                resultado.add(professor);
//            }
//        }
        return resultado;
    }

}