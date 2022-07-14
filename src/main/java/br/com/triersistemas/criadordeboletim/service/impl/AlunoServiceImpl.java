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
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<AlunoModel> consultar() {
        return alunoRepository.findAll().stream().map(AlunoModel::new).collect(Collectors.toList());
    }

    @Override
    public AlunoModel consultarPor(UUID id) {
        return new AlunoModel(this.buscaPorId(id));
    }

    @Override
    public AlunoModel cadastrar(AlunoModel model) {
        Aluno aluno = new Aluno(model);
        return new AlunoModel(alunoRepository.save(aluno));
    }

    @Override
    public AlunoModel alterar(AlunoModel model) {
        Aluno aluno = this.buscaPorId(model.getId());
        aluno.editar(model.getNomeCompleto());
        return new AlunoModel(this.alunoRepository.save(aluno));
    }

    @Override
    public AlunoModel remover(UUID id) {
        Aluno aluno = this.buscaPorId(id);
        alunoRepository.delete(aluno);
        return new AlunoModel(aluno);
    }

    private Aluno buscaPorId(UUID id) {
        return this.alunoRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
