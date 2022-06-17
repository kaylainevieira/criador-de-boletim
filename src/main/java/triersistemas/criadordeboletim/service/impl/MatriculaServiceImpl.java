package br.com.triersistemas.criadordeboletim.service.impl;

import br.com.triersistemas.criadordeboletim.entity.Aluno;
import br.com.triersistemas.criadordeboletim.entity.Matricula;
import br.com.triersistemas.criadordeboletim.exceptions.NaoExisteException;
import br.com.triersistemas.criadordeboletim.model.MatriculaModel;
import br.com.triersistemas.criadordeboletim.repository.MatriculaRepository;
import br.com.triersistemas.criadordeboletim.service.AlunoService;
import br.com.triersistemas.criadordeboletim.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoService alunoService;

    @Override
    public List<Matricula> consultar() {
        return matriculaRepository.consultar();
    }

    @Override
    public Matricula consultarPor(UUID id) {
        return matriculaRepository.consultarPor(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Matricula cadastrar(MatriculaModel model) {

        Aluno aluno = alunoService.consultarPor(model.getIdAluno());

        Matricula matricula = new Matricula(aluno,
                model.getUnidadeEscolar(), model.getMunicipio(),
                model.getEtapa(), model.getTurma(), model.getTurno(),
                model.getCurso(), model.getAvaliacao());
        matriculaRepository.cadastrar(matricula);
        return matricula;
    }

//    @Override
//    public Aluno alterar(UUID id, AlunoModel model) {
//        Aluno aluno = this.consultarPor(id);
//        aluno.editar(model.getNome(), model.getNiver(), model.getCpf(), model.getEmail());
//        return aluno;
//    }

    @Override
    public Matricula remover(UUID id) {
        Matricula matricula = this.consultarPor(id);
        matriculaRepository.remover(matricula);
        return matricula;
    }
}
