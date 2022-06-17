package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.entity.Matricula;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MatriculaRepository {

    List<Matricula> consultar();
    Optional<Matricula> consultarPor(UUID id);
    void cadastrar(Matricula boletim);
    void remover(Matricula boletim);
}
