package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {


    @Query(value = "" +
            "SELECT * " +
            "FROM aluno a " +
            "WHERE a.nome_completo ILIKE '%' || ?1 || '%'",
            nativeQuery = true)
    List<Aluno> buscarPeloNomeSQL(String nome);

}
