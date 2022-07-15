package br.com.triersistemas.criadordeboletim.repository;

import br.com.triersistemas.criadordeboletim.domain.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface NotaRepository extends JpaRepository<Nota, UUID> {

    List<Nota> findByValorGreaterThanEqual(BigDecimal valor);

    @Query(value = "SELECT n FROM Nota n WHERE (n.aluno.id) = (?1) AND (n.avaliacao) = (?2)")
    List<Nota> listaPorAvaliacaoJPQL(UUID idAluno, Integer avaliacao);
}
