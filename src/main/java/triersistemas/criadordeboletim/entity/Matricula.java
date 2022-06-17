package br.com.triersistemas.criadordeboletim.entity;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
public class Matricula {
	
	private UUID id;

	private Aluno aluno;
	
	private String unidadeEscolar;
	
	private String municipio;
	
	private Integer etapa;
	
	private Integer turma;
	
	private String turno;
	
	private String curso;
	
	private Integer ano;
	
	private Integer avaliacao;
	
	public Matricula() {
		super();
	}

	public Matricula(Aluno aluno,
					 String unidadeEscolar,
					 String municipio,
					 Integer etapa,
					 Integer turma,
					 String turno,
					 String curso,
					 Integer avaliacao) {
		this.id = UUID.randomUUID();
		this.aluno = aluno;
		this.unidadeEscolar = unidadeEscolar;
		this.municipio = municipio;
		this.etapa = etapa;
		this.turma = turma;
		this.turno = turno;
		this.curso = curso;
		this.ano = LocalDate.now().getYear();
		this.avaliacao = avaliacao;
	}

}
