package br.com.kaylaine.criadordeboletim.entity;

public class Materia {

	private int id;
	
	private String nome;
	
	private double nota;
	
	private int qtdeDeFalta;
	
	public Materia() {
		super();
	}

	public Materia(String nome, double nota, int qtdeDeFalta) {
		super();
		this.nome = nome;
		this.nota = nota;
		this.qtdeDeFalta = qtdeDeFalta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getQtdeDeFalta() {
		return qtdeDeFalta;
	}

	public void setQtdeDeFalta(int qtdeDeFalta) {
		this.qtdeDeFalta = qtdeDeFalta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
