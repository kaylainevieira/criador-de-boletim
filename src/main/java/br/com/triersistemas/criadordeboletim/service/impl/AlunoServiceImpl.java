package br.com.triersistemas.criadordeboletim.service.impl;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import br.com.triersistemas.criadordeboletim.exceptions.NaoExisteException;
import br.com.triersistemas.criadordeboletim.model.AlunoModel;
import br.com.triersistemas.criadordeboletim.repository.AlunoRepository;
import br.com.triersistemas.criadordeboletim.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> consultar() {
        return alunoRepository.consultar();
    }

    @Override
    public Aluno consultarPor(UUID id) {
        return alunoRepository.consultarPor(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Aluno cadastrar(AlunoModel model) {
        Aluno aluno = new Aluno(model.getNomeCompleto());
        alunoRepository.cadastrar(aluno);
        return aluno;
    }

    @Override
    public Aluno alterar(UUID id, AlunoModel model) {
        Aluno aluno = this.consultarPor(id);
        aluno.editar(model.getNomeCompleto());
        return aluno;
    }

    @Override
    public Aluno remover(UUID id) {
        Aluno aluno = this.consultarPor(id);
        alunoRepository.remover(aluno);
        return aluno;
    }
}
