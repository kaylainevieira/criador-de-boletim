package br.com.triersistemas.criadordeboletim.controller;

import br.com.triersistemas.criadordeboletim.entity.Materia;
import br.com.triersistemas.criadordeboletim.model.MateriaModel;
import br.com.triersistemas.criadordeboletim.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/consultar")
    public List<Materia> consultar() {
        return materiaService.consultar();
    }

    @PostMapping("/cadastrar")
    public Materia cadastrar(@RequestBody MateriaModel model) {
        return materiaService.cadastrar(model);
    }

//    @PutMapping("/alterar/{id}")
//    public Aluno alterar(@PathVariable UUID id, @RequestBody AlunoModel model) {
//        return alunoService.alterar(id, model);
//    }

    @DeleteMapping("/remover/{id}")
    public Materia remover(@PathVariable UUID id) {
        return materiaService.remover(id);
    }
}
