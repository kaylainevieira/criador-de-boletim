package br.com.triersistemas.criadordeboletim.repository.impl;

import br.com.triersistemas.criadordeboletim.entity.Materia;
import br.com.triersistemas.criadordeboletim.repository.MateriaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MateriaRepositoryImpl implements MateriaRepository {

    private static final List<Materia> LIST = new ArrayList<>();

    @Override
    public List<Materia> consultar() {
        return LIST;
    }

    @Override
    public Optional<Materia> consultarPor(UUID id) {
        return LIST.stream().filter(materia -> id.equals(materia.getId())).findFirst();
    }

    @Override
    public void cadastrar(Materia materia) {
        LIST.add(materia);
    }

    @Override
    public void remover(Materia materia) {
        LIST.remove(materia);
    }
}
