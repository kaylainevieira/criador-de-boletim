package br.com.triersistemas.criadordeboletim.repository.impl;


import br.com.triersistemas.criadordeboletim.entity.Aluno;
import br.com.triersistemas.criadordeboletim.repository.AlunoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {

    private static final List<Aluno> LIST = new ArrayList<>();

    @Override
    public List<Aluno> consultar() {
        return LIST;
    }

    @Override
    public Optional<Aluno> consultarPor(UUID id) {
        return LIST.stream().filter(aluno -> id.equals(aluno.getId())).findFirst();
    }

    @Override
    public void cadastrar(Aluno aluno) {
        LIST.add(aluno);
    }

    @Override
    public void remover(Aluno aluno) {
        LIST.remove(aluno);
    }
}
