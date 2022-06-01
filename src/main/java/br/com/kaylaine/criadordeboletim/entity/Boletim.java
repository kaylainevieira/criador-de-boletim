package br.com.kaylaine.criadordeboletim.entity;

import java.util.List;

public class Boletim {
	
	private int id;

	private Aluno aluno;
	
	private List<Materia> materias;
	
	private String unidadeEscolar;
	
	private String municipio;
	
	private int etapa;
	
	private int turma;
	
	private String turno;
	
	private int ano;
	
	private int avaliacao;
	
	public Boletim() {
		super();
	}

	public Boletim(Aluno aluno, List<Materia> materias, String unidadeEscolar, String municipio, int etapa,
			int turma, String turno, int ano, int avaliacao) {
		super();
		this.aluno = aluno;
		this.materias = materias;
		this.unidadeEscolar = unidadeEscolar;
		this.municipio = municipio;
		this.etapa = etapa;
		this.turma = turma;
		this.turno = turno;
		this.ano = ano;
		this.avaliacao = avaliacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public String getUnidadeEscolar() {
		return unidadeEscolar;
	}

	public void setUnidadeEscolar(String unidadeEscolar) {
		this.unidadeEscolar = unidadeEscolar;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getEtapa() {
		return etapa;
	}

	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}

	public int getTurma() {
		return turma;
	}

	public void setTurma(int turma) {
		this.turma = turma;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
