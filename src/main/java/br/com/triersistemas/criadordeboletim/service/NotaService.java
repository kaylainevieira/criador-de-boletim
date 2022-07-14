package br.com.triersistemas.criadordeboletim.service;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import br.com.triersistemas.criadordeboletim.domain.Matricula;
import br.com.triersistemas.criadordeboletim.domain.Nota;
import br.com.triersistemas.criadordeboletim.model.NotaModel;

import java.util.List;
import java.util.UUID;

public interface NotaService {


    List<NotaModel> consultar();

    //List<NotaModel> boletim(Integer avaliacao, UUID idAluno);

    NotaModel consultarPor(UUID id);
    NotaModel cadastrar(NotaModel model);

    NotaModel alterar(NotaModel model);
    NotaModel remover(UUID id);

}
