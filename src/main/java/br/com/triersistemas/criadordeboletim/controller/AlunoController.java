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
    public List<AlunoModel> consultar() {
        return alunoService.consultar();
    }

    @GetMapping("/consultar-por-id/{id}")
    public AlunoModel consultarPorId(@PathVariable UUID id) {
        return alunoService.consultarPor(id);
    }
    @PostMapping("/cadastrar")
    public AlunoModel cadastrar(@RequestBody @Valid AlunoModel model) {
        return alunoService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public AlunoModel alterar(@RequestBody @Valid AlunoModel model) {
        return alunoService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public AlunoModel remover(@PathVariable UUID id) {
        return alunoService.remover(id);
    }
}
