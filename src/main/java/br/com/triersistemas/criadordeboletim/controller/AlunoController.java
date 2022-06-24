package br.com.triersistemas.criadordeboletim.controller;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import br.com.triersistemas.criadordeboletim.model.AlunoModel;
import br.com.triersistemas.criadordeboletim.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/consultar")
    public List<Aluno> consultar() {
        return alunoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Aluno cadastrar(@RequestBody @Valid AlunoModel model) {
        return alunoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Aluno alterar(@PathVariable UUID id, @RequestBody @Valid AlunoModel model) {
        return alunoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Aluno remover(@PathVariable UUID id) {
        return alunoService.remover(id);
    }
}
