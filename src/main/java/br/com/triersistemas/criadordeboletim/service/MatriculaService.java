package br.com.triersistemas.criadordeboletim.service;

import br.com.triersistemas.criadordeboletim.entity.Matricula;
import br.com.triersistemas.criadordeboletim.model.MatriculaModel;

import java.util.List;
import java.util.UUID;

public interface MatriculaService {

    List<Matricula> consultar();

    Matricula consultarPor(UUID id);

    Matricula cadastrar(MatriculaModel model);
    Matricula remover(UUID id);
}
