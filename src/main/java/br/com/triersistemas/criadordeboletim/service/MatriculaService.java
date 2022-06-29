package br.com.triersistemas.criadordeboletim.service;

import br.com.triersistemas.criadordeboletim.domain.Matricula;
import br.com.triersistemas.criadordeboletim.model.MatriculaModel;

import java.util.List;
import java.util.UUID;

public interface MatriculaService {

    List<Matricula> consultar();
    Matricula consultarPor(UUID id);

    Matricula cadastrar(MatriculaModel model);

    Matricula alterar(UUID id, MatriculaModel model);
    Matricula remover(UUID id);
}
