package br.com.triersistemas.criadordeboletim.model;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import br.com.triersistemas.criadordeboletim.domain.Materia;
import br.com.triersistemas.criadordeboletim.domain.Nota;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class NotaModel {

    private UUID id;

    @NotNull(message = "O aluno é obrigatório.")
    private Aluno aluno;

    @NotNull(message = " A matéria é obrigatória.")
    private Materia materia;

    @NotNull(message = "O valor é obrigatório.")
    @Min(0)
    @Max(10)
    private BigDecimal valor;

    @NotNull(message = "A avaliação é obrigatória.")
    @Min(1)
    @Max(4)
    private Integer avaliacao;

    private LocalDateTime data;

    public NotaModel(Nota nota) {
        this.id = nota.getId();
        this.aluno = nota.getAluno();
        this.materia = nota.getMateria();
        this.valor = nota.getValor();
        this.avaliacao = nota.getAvaliacao();
        this.data = nota.getData();
    }
}
