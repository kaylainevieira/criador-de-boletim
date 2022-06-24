package br.com.triersistemas.criadordeboletim.model;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Getter
public class AlunoModel {

    @NotNull(message = "O nome completo é obrigatório.")
    @NotBlank(message = "O nome completo é obrigatório.")
    @Pattern(regexp = "[A-Za-zÀ-ú]{2,70}",
            message = "O nome completo deve ter entre 2 e 70 caracteres literais.")
    private String nomeCompleto;
}
