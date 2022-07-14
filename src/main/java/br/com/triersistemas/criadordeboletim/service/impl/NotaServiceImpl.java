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

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private MateriaService materiaService;

       /*
    @Override
    public List<Nota> consultar() {
        return notaRepository.consultar();
    }

    @Override
    public List<Nota> boletim(Integer avaliacao, UUID idAluno){
        return notaRepository.boletim(avaliacao, idAluno);
    }

    @Override
    public Nota consultarPor(UUID id) {
        return notaRepository.consultarPor(id).orElseThrow(NaoExisteException::new);
    }


    @Override
    public Nota cadastrar(NotaModel model) {
        Aluno aluno = alunoService.consultarPor(model.getIdAluno());
        Materia materia = materiaService.consultarPor(model.getIdMateria());

        Nota nota = new Nota(aluno, materia, model.getValor(), model.getAvaliacao());
        notaRepository.cadastrar(nota);
        return nota;
    }

    @Override
    public Nota alterar(UUID id, NotaModel model) {
        Nota nota = this.consultarPor(id);

        Aluno aluno = alunoService.consultarPor(model.getIdAluno());
        Materia materia = materiaService.consultarPor(model.getIdMateria());

        nota.editar(aluno, materia, model.getValor(), model.getAvaliacao());
        return nota;
    }

    @Override
    public Nota remover(UUID id) {
        Nota nota = this.consultarPor(id);
        notaRepository.remover(nota);
        return nota;
    }*/
}
