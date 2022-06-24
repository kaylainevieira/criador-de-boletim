package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.domain.Nota;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotaRepository {

    List<Nota> consultar();
    Optional<Nota> consultarPor(UUID id);
    void cadastrar(Nota nota);
    void remover(Nota nota);
}
