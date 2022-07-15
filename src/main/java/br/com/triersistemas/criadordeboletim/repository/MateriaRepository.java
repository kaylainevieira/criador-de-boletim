package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.domain.Materia;
import br.com.triersistemas.criadordeboletim.repository.impl.MateriaRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MateriaRepository extends JpaRepository<Materia, UUID> ,MateriaRepositoryCustom {

}
