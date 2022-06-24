package br.com.triersistemas.criadordeboletim.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Materia {

	private UUID id;
	
	private String nome;

	public Materia(final String nome) {
		this.id = UUID.randomUUID();
		this.nome = nome;;
	}

	public Materia editar(final String nome) {
		this.nome = nome;
		return this;
	}

//	public BigDecimal getMediaFinal() {
//		BigDecimal soma = notas.stream().map(x -> x.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
//		return soma.divide(BigDecimal.valueOf(notas.size()));
//	}
}
