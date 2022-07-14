package br.com.triersistemas.criadordeboletim.service;

import br.com.triersistemas.criadordeboletim.domain.Materia;
import br.com.triersistemas.criadordeboletim.model.MateriaModel;

import java.util.List;
import java.util.UUID;

public interface MateriaService {

    List<MateriaModel> consultar();
    MateriaModel consultarPor(UUID id);
    MateriaModel cadastrar(MateriaModel model);

    MateriaModel alterar(MateriaModel model);
    MateriaModel remover(UUID id);
}
