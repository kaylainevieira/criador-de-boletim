package br.com.triersistemas.criadordeboletim.service.impl;

import br.com.triersistemas.criadordeboletim.domain.Materia;
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

    @Override
    public Materia alterar(UUID id, MateriaModel model) {
        Materia materia = this.consultarPor(id);
        materia.editar(model.getNome());
        return materia;
    }

    @Override
    public Materia remover(UUID id) {
        Materia materia = this.consultarPor(id);
        materiaRepository.remover(materia);
        return materia;
    }
}
