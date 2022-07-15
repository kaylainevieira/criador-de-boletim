package br.com.triersistemas.criadordeboletim.model;

import br.com.triersistemas.criadordeboletim.domain.Aluno;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Getter
@NoArgsConstructor
public class AlunoModel {

    private UUID id;

    @NotNull(message = "O nome completo é obrigatório.")
    @NotBlank(message = "O nome completo é obrigatório.")
    /*@Pattern(regexp = "[A-Za-zÀ-ú]{2,100}",
            message = "O nome completo deve ter entre 2 e 100 caracteres literais.")*/
    private String nomeCompleto;

    public AlunoModel(Aluno aluno) {
        this.id = aluno.getId();
        this.nomeCompleto = aluno.getNomeCompleto();
    }
}
