
package br.com.triersistemas.criadordeboletim.domain;

import br.com.triersistemas.criadordeboletim.model.AlunoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "aluno")
@NoArgsConstructor
@Getter
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",
			insertable = false, updatable = false,
			nullable = false, unique = true)
	private UUID id;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	public Aluno(AlunoModel model) {
		this.nomeCompleto = model.getNomeCompleto();
	}

	public Aluno editar(final String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
		return this;
	}
}