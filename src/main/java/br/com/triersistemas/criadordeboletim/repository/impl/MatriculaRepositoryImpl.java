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
        return LIST.stream().filter(boletim -> id.equals(boletim.getId())).findFirst();
    }

    @Override
    public void cadastrar(Matricula boletim) {
        LIST.add(boletim);
    }

    @Override
    public void remover(Matricula boletim) {
        LIST.remove(boletim);
    }
}
