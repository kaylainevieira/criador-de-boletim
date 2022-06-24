package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.domain.Materia;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MateriaRepository {

    List<Materia> consultar();
    Optional<Materia> consultarPor(UUID id);
    void cadastrar(Materia materia);
    void remover(Materia materia);
}
