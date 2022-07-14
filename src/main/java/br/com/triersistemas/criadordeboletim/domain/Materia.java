package br.com.triersistemas.criadordeboletim.domain;

import br.com.triersistemas.criadordeboletim.model.AlunoModel;
import br.com.triersistemas.criadordeboletim.model.MateriaModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "materia")
@NoArgsConstructor
@Getter
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",
			insertable = false, updatable = false,
			nullable = false, unique = true)
	private UUID id;
	
	private String nome;

	public Materia(MateriaModel model) {
		this.nome = model.getNome();
	}

	public Materia editar(final String nome) {
		this.nome = nome;
		return this;
	}
}
