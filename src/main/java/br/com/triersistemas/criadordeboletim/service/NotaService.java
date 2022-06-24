package br.com.triersistemas.criadordeboletim.service;

import br.com.triersistemas.criadordeboletim.domain.Nota;
import br.com.triersistemas.criadordeboletim.model.NotaModel;

import java.util.List;
import java.util.UUID;

public interface NotaService {

    List<Nota> consultar();
    Nota consultarPor(UUID id);
    Nota cadastrar(NotaModel model);

    Nota alterar(UUID id, NotaModel model);
    Nota remover(UUID id);
}
