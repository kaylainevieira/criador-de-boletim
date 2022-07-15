package br.com.triersistemas.criadordeboletim.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "nota")
@NoArgsConstructor
@Getter
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            insertable = false, updatable = false,
            nullable = false, unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "materia_id", referencedColumnName = "id")
    private Materia materia;

    private BigDecimal valor;

    private Integer avaliacao;

    private LocalDateTime data;
    public Nota(Aluno aluno, Materia materia, BigDecimal valor, Integer avaliacao, LocalDateTime data) {
        this.aluno = aluno;
        this.materia = materia;
        this.valor = valor;
        this.avaliacao = avaliacao;
        this.data = LocalDateTime.now();
    }

    public Nota editar(final Aluno aluno,
                       final Materia materia,
                       final BigDecimal valor,
                       final Integer avaliacao) {
        this.aluno = aluno;
        this.materia = materia;
        this.valor = valor;
        this.avaliacao = avaliacao;
        this.data = LocalDateTime.now();
        return this;
    }
}
