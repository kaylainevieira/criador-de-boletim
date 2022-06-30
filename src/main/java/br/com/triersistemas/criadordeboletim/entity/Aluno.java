package br.com.triersistemas.criadordeboletim.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Aluno {

	private UUID id;
	
	private String nomeCompleto;

	public Aluno(final String nomeCompleto) {
		this.id = UUID.randomUUID();
		this.nomeCompleto = nomeCompleto;
	}

	public Aluno editar(final String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
		return this;
	}
}