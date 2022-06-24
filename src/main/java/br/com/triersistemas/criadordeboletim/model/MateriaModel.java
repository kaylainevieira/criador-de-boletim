package br.com.triersistemas.criadordeboletim.model;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Getter
public class MateriaModel {

    @NotNull(message = "O nome é obrigatório.")
    @NotBlank(message = "O nome é obrigatório.")
    @Pattern(regexp = "[A-Za-zÀ-ú]{2,70}",
            message = "O nome deve ter entre 2 e 70 caracteres literais.")
    private String nome;
}
