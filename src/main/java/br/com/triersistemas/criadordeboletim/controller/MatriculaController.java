package br.com.triersistemas.criadordeboletim.controller;

import br.com.triersistemas.criadordeboletim.domain.Matricula;
import br.com.triersistemas.criadordeboletim.model.MatriculaModel;
import br.com.triersistemas.criadordeboletim.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
/*
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/consultarPorAluno/{idAluno}")
    public Matricula consultarPorAluno(@PathVariable UUID idAluno) {
        return matriculaService.consultarPorAluno(idAluno);
    }

    @GetMapping("/consultar")
    public List<Matricula> consultar() {
        return matriculaService.consultar();
    }

    @PostMapping("/cadastrar")
    public Matricula cadastrar(@RequestBody @Valid MatriculaModel model) {
        return matriculaService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Matricula alterar(@PathVariable UUID id, @RequestBody @Valid MatriculaModel model) {
        return matriculaService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Matricula remover(@PathVariable UUID id) {
        return matriculaService.remover(id);
    }

 */
}
