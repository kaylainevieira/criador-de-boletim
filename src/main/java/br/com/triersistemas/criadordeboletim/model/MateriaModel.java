package br.com.triersistemas.criadordeboletim.model;

import br.com.triersistemas.criadordeboletim.domain.Materia;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class MateriaModel {

    private UUID id;

    @NotNull(message = "O nome é obrigatório.")
    @NotBlank(message = "O nome é obrigatório.")
    /*@Pattern(regexp = "[A-Za-zÀ-ú]{2,30}",
            message = "O nome deve ter entre 2 e 30 caracteres literais.")*/
    private String nome;

    public MateriaModel(Materia materia) {
        this.id = materia.getId();
        this.nome = materia.getNome();
    }
}
