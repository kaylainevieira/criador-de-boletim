package br.com.triersistemas.criadordeboletim.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Nota {

    private UUID id;

    private Aluno aluno;

    private Materia materia;

    private BigDecimal valor;

    private LocalDateTime data;

    public Nota(final Aluno aluno,
                final Materia materia,
                final BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.aluno = aluno;
        this.materia = materia;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public Nota editar(final Aluno aluno,
                final Materia materia,
                final BigDecimal valor) {
        this.aluno = aluno;
        this.materia = materia;
        this.valor = valor;
        this.data = LocalDateTime.now();
        return this;
    }
}
