package br.com.triersistemas.criadordeboletim.service.impl;

import br.com.triersistemas.criadordeboletim.entity.Aluno;
import br.com.triersistemas.criadordeboletim.entity.Materia;
import br.com.triersistemas.criadordeboletim.entity.Nota;
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

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private MateriaService materiaService;

    @Override
    public List<Nota> consultar() {
        return notaRepository.consultar();
    }

    @Override
    public Nota consultarPor(UUID id) {
        return notaRepository.consultarPor(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Nota cadastrar(NotaModel model) {
        Aluno aluno = alunoService.consultarPor(model.getIdAluno());
        Materia materia = materiaService.consultarPor(model.getIdMateria());

        Nota nota = new Nota(aluno, materia, model.getValor());
        notaRepository.cadastrar(nota);
        return nota;
    }

//    @Override
//    public Aluno alterar(UUID id, AlunoModel model) {
//        Aluno aluno = this.consultarPor(id);
//        aluno.editar(model.getNome(), model.getNiver(), model.getCpf(), model.getEmail());
//        return aluno;
//    }

    @Override
    public Nota remover(UUID id) {
        Nota nota = this.consultarPor(id);
        notaRepository.remover(nota);
        return nota;
    }
}
