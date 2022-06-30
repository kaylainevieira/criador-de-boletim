package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.domain.Matricula;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MatriculaRepository {

    List<Matricula> consultar();
    Optional<Matricula> consultarPor(UUID id);

    Optional<Matricula> consultarPorAluno(UUID idAluno);
    void cadastrar(Matricula matricula);
    void remover(Matricula matricula);
}
