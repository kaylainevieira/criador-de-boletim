package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.domain.Materia;

import java.util.List;

public interface MateriaRepositoryCustom {

    List<Materia> listarPorNome(String nome);
}
