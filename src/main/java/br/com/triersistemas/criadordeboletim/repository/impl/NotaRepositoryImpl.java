package br.com.triersistemas.criadordeboletim.repository.impl;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import br.com.triersistemas.criadordeboletim.domain.Nota;
import br.com.triersistemas.criadordeboletim.repository.NotaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class NotaRepositoryImpl implements NotaRepository {

    private static final List<Nota> LIST = new ArrayList<>();

    @Override
    public List<Nota> consultar() {
        return LIST;
    }

    @Override
    public List<Nota> boletim(Integer avaliacao, UUID idAluno) {
        return LIST.stream().filter(nota -> nota.getAvaliacao().equals(avaliacao)
                && nota.getAluno().getId().equals(idAluno)).collect(Collectors.toList());
    }
    @Override
    public Optional<Nota> consultarPor(UUID id) {
        return LIST.stream().filter(nota -> id.equals(nota.getId())).findFirst();
    }

    @Override
    public void cadastrar(Nota nota) {
        LIST.add(nota);
    }

    @Override
    public void remover(Nota nota) {
        LIST.remove(nota);
    }
}
