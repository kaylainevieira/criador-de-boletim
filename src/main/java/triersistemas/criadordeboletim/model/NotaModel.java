package br.com.triersistemas.criadordeboletim.model;

import br.com.triersistemas.criadordeboletim.entity.Aluno;
import br.com.triersistemas.criadordeboletim.entity.Materia;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class NotaModel {

    private UUID idAluno;

    private UUID idMateria;

    private BigDecimal valor;
}
