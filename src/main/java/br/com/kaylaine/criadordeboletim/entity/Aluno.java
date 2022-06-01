package br.com.kaylaine.criadordeboletim.entity;

public class Aluno {
	
	private int id;

	private int matricula;
	
	private String nomeCompleto;

	public Aluno() {
		super();
	}

	public Aluno(int matricula, String nomeCompleto) {
		super();
		this.matricula = matricula;
		this.nomeCompleto = nomeCompleto;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
}