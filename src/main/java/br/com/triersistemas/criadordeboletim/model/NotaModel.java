package br.com.triersistemas.criadordeboletim.model;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class NotaModel {

    @NotNull(message = "O id do aluno é obrigatória.")
    @NotBlank(message = "O id do aluno é obrigatório.")
    private UUID idAluno;

    @NotNull(message = "O id da matéria é obrigatória.")
    @NotBlank(message = "O id da matéria é obrigatório.")
    private UUID idMateria;

    @NotNull(message = "O valor é obrigatório.")
    @NotBlank(message = "O valor é obrigatório.")
    @Min(0)
    @Max(10)
    private BigDecimal valor;
}
