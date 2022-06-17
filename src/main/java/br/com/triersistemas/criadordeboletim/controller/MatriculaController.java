package br.com.triersistemas.criadordeboletim.controller;

import br.com.triersistemas.criadordeboletim.entity.Matricula;
import br.com.triersistemas.criadordeboletim.model.MatriculaModel;
import br.com.triersistemas.criadordeboletim.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/consultar")
    public List<Matricula> consultar() {
        return matriculaService.consultar();
    }

    @PostMapping("/cadastrar")
    public Matricula cadastrar(@RequestBody MatriculaModel model) {
        return matriculaService.cadastrar(model);
    }

//    @PutMapping("/alterar/{id}")
//    public Aluno alterar(@PathVariable UUID id, @RequestBody AlunoModel model) {
//        return alunoService.alterar(id, model);
//    }

    @DeleteMapping("/remover/{id}")
    public Matricula remover(@PathVariable UUID id) {
        return matriculaService.remover(id);
    }
}
