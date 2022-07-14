package br.com.triersistemas.criadordeboletim.service.impl;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import br.com.triersistemas.criadordeboletim.domain.Materia;
import br.com.triersistemas.criadordeboletim.domain.Nota;
import br.com.triersistemas.criadordeboletim.exceptions.NaoExisteException;
import br.com.triersistemas.criadordeboletim.model.NotaModel;
import br.com.triersistemas.criadordeboletim.repository.NotaRepository;
import br.com.triersistemas.criadordeboletim.service.AlunoService;
import br.com.triersistemas.criadordeboletim.service.MateriaService;
import br.com.triersistemas.criadordeboletim.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlunoServiceImpl alunoService;

    @Autowired
    private MateriaServiceImpl materiaService;


    @Override
    public List<NotaModel> consultar() {
        return notaRepository.findAll().stream().map(NotaModel::new).collect(Collectors.toList());
    }

    /*
    @Override
    public List<NotaModel> boletim(Integer avaliacao, UUID idAluno){
        return notaRepository.findAll().stream().filter(nota -> nota.getAvaliacao().equals(avaliacao)
                && nota.getAluno().getId().equals(idAluno)).collect(Collectors.toList());
    }*/

    @Override
    public NotaModel consultarPor(UUID id) {
        return new NotaModel(this.buscarPorId(id));
    }


    @Override
    public NotaModel cadastrar(NotaModel model) {
        Aluno aluno = alunoService.consultarAluno(model.getAluno().getId());
        Materia materia = materiaService.consultarMateria(model.getMateria().getId());

        Nota nota = new Nota(aluno, materia, model.getValor(), model.getAvaliacao(), model.getData());
        return new NotaModel(notaRepository.save(nota));
    }

    @Override
    public NotaModel alterar(NotaModel model) {
        Nota nota = this.buscarPorId(model.getId());

        Aluno aluno = alunoService.consultarAluno(model.getAluno().getId());
        Materia materia = materiaService.consultarMateria(model.getMateria().getId());

        nota.editar(aluno, materia, model.getValor(), model.getAvaliacao());
        return new NotaModel(notaRepository.save(nota));
    }

    @Override
    public NotaModel remover(UUID id) {
        Nota nota = this.buscarPorId(id);
        notaRepository.delete(nota);
        return new NotaModel(nota);
    }

    public Nota buscarPorId(UUID id) {
        return notaRepository.findById(id).orElseThrow(NaoExisteException::new);
    }

}
