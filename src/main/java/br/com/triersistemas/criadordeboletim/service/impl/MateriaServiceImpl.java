package br.com.triersistemas.criadordeboletim.service.impl;

import br.com.triersistemas.criadordeboletim.entity.Materia;
import br.com.triersistemas.criadordeboletim.entity.Nota;
import br.com.triersistemas.criadordeboletim.exceptions.NaoExisteException;
import br.com.triersistemas.criadordeboletim.model.MateriaModel;
import br.com.triersistemas.criadordeboletim.repository.MateriaRepository;
import br.com.triersistemas.criadordeboletim.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<Materia> consultar() {
        return materiaRepository.consultar();
    }

    @Override
    public Materia consultarPor(UUID id) {
        return materiaRepository.consultarPor(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Materia cadastrar(MateriaModel model) {
        Materia materia = new Materia(model.getNome());
        materiaRepository.cadastrar(materia);
        return materia;
    }

//    @Override
//    public Aluno alterar(UUID id, AlunoModel model) {
//        Aluno aluno = this.consultarPor(id);
//        aluno.editar(model.getNome(), model.getNiver(), model.getCpf(), model.getEmail());
//        return aluno;
//    }

    @Override
    public Materia remover(UUID id) {
        Materia materia = this.consultarPor(id);
        materiaRepository.remover(materia);
        return materia;
    }
}
