package br.com.triersistemas.criadordeboletim.service;

import br.com.triersistemas.criadordeboletim.entity.Materia;
import br.com.triersistemas.criadordeboletim.model.MateriaModel;

import java.util.List;
import java.util.UUID;

public interface MateriaService {

    List<Materia> consultar();
    Materia consultarPor(UUID id);
    Materia cadastrar(MateriaModel model);
    Materia remover(UUID id);
}
