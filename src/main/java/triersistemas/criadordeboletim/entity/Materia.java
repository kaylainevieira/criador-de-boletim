package br.com.triersistemas.criadordeboletim.entity;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Materia {

	private UUID id;
	
	private String nome;

	public Materia(final String nome) {
		this.id = UUID.randomUUID();
		this.nome = nome;;
	}

//	public BigDecimal getMediaFinal() {
//		BigDecimal soma = notas.stream().map(x -> x.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
//		return soma.divide(BigDecimal.valueOf(notas.size()));
//	}
}
