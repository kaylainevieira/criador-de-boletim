package br.com.triersistemas.criadordeboletim.service;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import br.com.triersistemas.criadordeboletim.model.AlunoModel;

import java.util.List;
import java.util.UUID;

public interface AlunoService {

    List<Aluno> consultar();
    Aluno consultarPor(UUID id);
    Aluno cadastrar(AlunoModel model);
    Aluno alterar(UUID id, AlunoModel model);
    Aluno remover(UUID id);
}
