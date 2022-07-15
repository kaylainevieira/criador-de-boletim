package br.com.triersistemas.criadordeboletim.controller;

import br.com.triersistemas.criadordeboletim.model.NotaModel;
import br.com.triersistemas.criadordeboletim.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping("/consultar-por-id/{id}")
    public NotaModel consultarPor(@PathVariable UUID id) {
        return notaService.consultarPor(id);
    }
    @GetMapping("/consultar")
    public List<NotaModel> consultar() {
        return notaService.consultar();
    }
/*
    @GetMapping("/boletim/{avaliacao}/{idAluno}")
    public List<NotaModel> boletim(@PathVariable Integer avaliacao, @PathVariable UUID idAluno) {
        return notaService.boletim(avaliacao, idAluno);
    }
*/
    @PostMapping("/cadastrar")
    public NotaModel cadastrar(@RequestBody @Valid NotaModel model) {
        return notaService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public NotaModel alterar(@RequestBody @Valid NotaModel model) {
        return notaService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public NotaModel remover(@PathVariable UUID id) {
        return notaService.remover(id);
    }

    @GetMapping("/valor-maior-ou-igual-a/{valor}")
    public List<NotaModel> findByNotaGreaterThanEqual(@PathVariable BigDecimal valor) {
        return notaService.findByNotaGreaterThanEqual(valor);
    }

    @GetMapping("/lista-por-avaliacao/{idAluno}/{avaliacao}")
    public List<NotaModel> listaPorAvaliacaoJPQL(@PathVariable UUID idAluno,@PathVariable Integer avaliacao){
        return notaService.listaPorAvaliacaoJPQL(idAluno, avaliacao);
    }
}
