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

    protected Aluno consultarAluno(UUID id) {
        return this.buscarPorId(id);
    }

    @Override
    public List<AlunoModel> consultar() {
        return alunoRepository.findAll().stream().map(AlunoModel::new).collect(Collectors.toList());
    }

    @Override
    public AlunoModel consultarPor(UUID id) {
        return new AlunoModel(this.buscarPorId(id));
    }

    @Override
    public AlunoModel cadastrar(AlunoModel model) {
        Aluno aluno = new Aluno(model);
        return new AlunoModel(alunoRepository.save(aluno));
    }

    @Override
    public AlunoModel alterar(AlunoModel model) {
        Aluno aluno = this.buscarPorId(model.getId());
        aluno.editar(model.getNomeCompleto());
        return new AlunoModel(this.alunoRepository.save(aluno));
    }

    @Override
    public AlunoModel remover(UUID id) {
        Aluno aluno = this.buscarPorId(id);
        alunoRepository.delete(aluno);
        return new AlunoModel(aluno);
    }

    @Override
    public List<AlunoModel> buscarPeloNomeSQL(String nome) {
        return alunoRepository.buscarPeloNomeSQL(nome).stream().map(AlunoModel::new).toList();
    }

    private Aluno buscarPorId(UUID id) {
        return this.alunoRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
