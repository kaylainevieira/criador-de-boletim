package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.domain.Aluno;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository {

    List<Aluno> consultar();
    Optional<Aluno> consultarPor(UUID id);
    void cadastrar(Aluno aluno);
    void remover(Aluno aluno);
}
