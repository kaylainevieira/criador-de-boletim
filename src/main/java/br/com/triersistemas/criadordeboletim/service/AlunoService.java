package br.com.triersistemas.criadordeboletim.service;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import br.com.triersistemas.criadordeboletim.model.AlunoModel;

import java.util.List;
import java.util.UUID;

public interface AlunoService {

    List<AlunoModel> consultar();
    AlunoModel consultarPor(UUID id);
    AlunoModel cadastrar(AlunoModel model);
    AlunoModel alterar(AlunoModel model);
    AlunoModel remover(UUID id);
}
