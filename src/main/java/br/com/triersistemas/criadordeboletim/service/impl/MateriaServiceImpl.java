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
import java.util.stream.Collectors;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    protected Materia consultarMateria(UUID id) {
        return this.buscarPorId(id);
    }

    @Override
    public List<MateriaModel> consultar() {
        return materiaRepository.findAll().stream().map(MateriaModel::new).collect(Collectors.toList());
    }

    @Override
    public MateriaModel consultarPor(UUID id) {
        return new MateriaModel(this.buscarPorId(id));
    }

    @Override
    public MateriaModel cadastrar(MateriaModel model) {
        Materia materia = new Materia(model);
        return new MateriaModel(materiaRepository.save(materia));
    }

    @Override
    public MateriaModel alterar(MateriaModel model) {
        Materia materia = this.buscarPorId(model.getId());
        materia.editar(model.getNome());
        return new MateriaModel(materiaRepository.save(materia));
    }

    @Override
    public MateriaModel remover(UUID id) {
        Materia materia = this.buscarPorId(id);
        materiaRepository.delete(materia);
        return new MateriaModel(materia);
    }

    @Override
    public List<Materia> listarPorNome(String nome) {
        return this.materiaRepository.listarPorNome(nome);
    }

    public Materia buscarPorId(UUID id) {
        return materiaRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
