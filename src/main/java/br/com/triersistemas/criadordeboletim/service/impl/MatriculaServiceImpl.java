package br.com.triersistemas.criadordeboletim.service.impl;

import br.com.triersistemas.criadordeboletim.repository.MatriculaRepository;
import br.com.triersistemas.criadordeboletim.service.AlunoService;
import br.com.triersistemas.criadordeboletim.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoService alunoService;
/*
    @Override
    public List<Matricula> consultar() {
        return matriculaRepository.consultar();
    }

    @Override
    public Matricula consultarPor(UUID id) {
        return matriculaRepository.consultarPor(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Matricula consultarPorAluno(UUID idAluno) {
        return matriculaRepository.consultarPorAluno(idAluno).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Matricula cadastrar(MatriculaModel model) {
        Aluno aluno = alunoService.consultarPor(model.getIdAluno());

        Matricula matricula = new Matricula(aluno,
                model.getUnidadeEscolar(), model.getMunicipio(),
                model.getEtapa(), model.getTurma(), model.getTurno(),
                model.getCurso());
        matriculaRepository.cadastrar(matricula);
        return matricula;
    }

    @Override
    public Matricula alterar(UUID id, MatriculaModel model) {
        Matricula matricula = this.consultarPor(id);

        Aluno aluno = alunoService.consultarPor(model.getIdAluno());

        matricula.editar(aluno,
                model.getUnidadeEscolar(), model.getMunicipio(),
                model.getEtapa(), model.getTurma(), model.getTurno(), model.getCurso());
        return matricula;
    }

    @Override
    public Matricula remover(UUID id) {
        Matricula matricula = this.consultarPor(id);
        matriculaRepository.remover(matricula);
        return matricula;
    }
    */

}
