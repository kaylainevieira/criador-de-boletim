package br.com.triersistemas.criadordeboletim.controller;

import br.com.triersistemas.criadordeboletim.domain.Nota;
import br.com.triersistemas.criadordeboletim.model.NotaModel;
import br.com.triersistemas.criadordeboletim.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping("/consultar")
    public List<Nota> consultar() {
        return notaService.consultar();
    }

    @PostMapping("/cadastrar")
    public Nota cadastrar(@RequestBody @Valid NotaModel model) {
        return notaService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Nota alterar(@PathVariable UUID id, @RequestBody @Valid NotaModel model) {
        return notaService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Nota remover(@PathVariable UUID id) {
        return notaService.remover(id);
    }
}
