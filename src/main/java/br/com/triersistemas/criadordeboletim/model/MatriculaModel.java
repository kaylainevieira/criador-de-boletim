package br.com.triersistemas.criadordeboletim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class MatriculaModel {

    @NotNull(message = "O id do aluno é obrigatória.")
    private UUID idAluno;

    @NotNull(message = "A unidade escolar é obrigatória.")
    @NotBlank(message = "A unidade escolar é obrigatório.")
    @Pattern(regexp = "[A-Za-zÀ-ú]{2,30}",
            message = "A unidade escolar deve ter entre 2 e 30 caracteres literais.")
    private String unidadeEscolar;

    @NotNull(message = "O município é obrigatório.")
    @NotBlank(message = "O município é obrigatório.")
    @Pattern(regexp = "[A-Za-zÀ-ú]{2,30}",
            message = "O município deve ter entre 2 e 30 caracteres literais.")
    private String municipio;

    @NotNull(message = "A etapa é obrigatória.")
    @Min(1)
    @Max(9)
    private Integer etapa;

    @NotNull(message = "A turma é obrigatória.")
    private Integer turma;

    @NotNull(message = "O turno é obrigatório.")
    @NotBlank(message = "O turno é obrigatório.")
    @Pattern(regexp = "[A-Za-zÀ-ú]{2,30}",
            message = "O turno deve ter entre 2 e 30 caracteres literais.")
    private String turno;

    @NotNull(message = "O curso é obrigatório.")
    @NotBlank(message = "O curso é obrigatório.")
    @Pattern(regexp = "[A-Za-zÀ-ú]{2,30}",
            message = "O curso deve ter entre 2 e 30 caracteres literais.")
    private String curso;
}
