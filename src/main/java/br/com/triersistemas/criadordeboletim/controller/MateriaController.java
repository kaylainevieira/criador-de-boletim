package br.com.triersistemas.criadordeboletim.controller;

import br.com.triersistemas.criadordeboletim.domain.Materia;
import br.com.triersistemas.criadordeboletim.model.AlunoModel;
import br.com.triersistemas.criadordeboletim.model.MateriaModel;
import br.com.triersistemas.criadordeboletim.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/consultar")
    public List<MateriaModel> consultar() {
        return materiaService.consultar();
    }

    @GetMapping("/consultar-por-id/{id}")
    public MateriaModel consultarPor(@PathVariable UUID id) {
        return materiaService.consultarPor(id);
    }

    @PostMapping("/cadastrar")
    public MateriaModel cadastrar(@RequestBody @Valid MateriaModel model) {
        return materiaService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public MateriaModel alterar(@RequestBody @Valid MateriaModel model) {
        return materiaService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public MateriaModel remover(@PathVariable UUID id) {
        return materiaService.remover(id);
    }

    @GetMapping          ("/buscar-pelo-nome/{nome}")
    List<Materia> listarPorNome(@PathVariable String nome) {
        return materiaService.listarPorNome(nome);
    }
}
