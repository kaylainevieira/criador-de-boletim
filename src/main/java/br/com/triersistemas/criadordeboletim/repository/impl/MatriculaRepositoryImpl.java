package br.com.triersistemas.criadordeboletim.repository.impl;

import br.com.triersistemas.criadordeboletim.domain.Matricula;
import br.com.triersistemas.criadordeboletim.repository.MatriculaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MatriculaRepositoryImpl implements MatriculaRepository {

    private static final List<Matricula> LIST = new ArrayList<>();

    @Override
    public List<Matricula> consultar() {
        return LIST;
    }

    @Override
    public Optional<Matricula> consultarPor(UUID id) {
        return LIST.stream().filter(matricula -> id.equals(matricula.getId())).findFirst();
    }

    @Override
    public Optional<Matricula> consultarPorAluno(UUID idAluno) {
        return LIST.stream().filter(matricula -> idAluno.equals(matricula.getAluno().getId())).findFirst();
    }

    @Override
    public void cadastrar(Matricula matricula) {
        LIST.add(matricula);
    }

    @Override
    public void remover(Matricula matricula) {
        LIST.remove(matricula);
    }
}
