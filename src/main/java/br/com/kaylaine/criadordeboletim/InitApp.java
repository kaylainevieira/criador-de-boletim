package br.com.kaylaine.criadordeboletim;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.kaylaine.criadordeboletim.entity.Aluno;
import br.com.kaylaine.criadordeboletim.entity.Boletim;
import br.com.kaylaine.criadordeboletim.entity.Materia;
import br.com.kaylaine.criadordeboletim.exceptions.VerificarDecimalNotaException;
import br.com.kaylaine.criadordeboletim.exceptions.VerificarInteiroException;
import br.com.kaylaine.criadordeboletim.exceptions.VerificarLiteralException;
import br.com.kaylaine.criadordeboletim.repository.AlunoRepository;
import br.com.kaylaine.criadordeboletim.repository.BoletimRepository;
import br.com.kaylaine.criadordeboletim.repository.MateriaRepository;

public class InitApp {

	public static Scanner sc = new Scanner(System.in);
	
	public static final int QTDE_TOTAL_CARACTERES = 80;

	public static void main(String[] args) {

//		Aluno novoAluno = new Aluno(45454545, "Kaylaine");
//		
//		List<Materia> materias = new ArrayList<Materia>();
//		
//		Materia m1 = new Materia("Bio", 9.5, 1);
//		Materia m2 = new Materia("Geo", 4, 2);
//		Materia m3 = new Materia("Mat", 7, 5);
//		
//		materias.add(m1);
//		materias.add(m2);
//		materias.add(m3);
//
//		Boletim boletim = new Boletim(novoAluno,materias, "unidadeEscolar", "municipio", 1,
//				8, "NOTURNO", 2020, 1);
//		
//		System.out.println(gerarBoletimEscrito(boletim));
		
		Aluno novoAluno = new Aluno();
		novoAluno = perguntarInformaçõesAluno();
		
		List<Materia> materias = new ArrayList<Materia>();
		materias = cadastrarMaterias(novoAluno);
		
		Boletim boletim = new Boletim();
		boletim = criarBoletim(novoAluno, materias);
		
		//do {
			//mostrarMenu();
			
			//int opcaoDeMenu 
			
		//} while (condition);
		
		
		System.out.println(boletim);
		
		sc.close();
	}

	private static void mostrarMenu() {
		System.out.println(
				"""
				Informe:
				1 - Cadastrar boletim.
				2 - Listar boletins.
				3 - Excluir boletins.
				4 - Sair.
				""");
	}
	
	private static Aluno perguntarInformaçõesAluno() {
		boolean isContinuar = false;
			do {
				try {
					Aluno novoAluno = new Aluno();

					System.out.println("Informe a nome do aluno(a):");
					String nomeCompletoInformado = sc.next();

					if (!nomeCompletoInformado.matches("[A-Za-zÀ-ú]{2,60}")) {
						throw new VerificarLiteralException(
								"Erro! O nome completo deve ter entre 2 e 60 caracteres literais.");
					}

					System.out.println("Informe a matrícula do aluno(a):");
					String matriculaInformadaEscrita = sc.next();
					
					if (!matriculaInformadaEscrita.matches("[0-9]{10}")) {
						throw new VerificarInteiroException(
								"Erro! A matricula deve ter 10 caracteres inteiros positivo.");
					}
					
					int matriculaInformada = Integer.valueOf(matriculaInformadaEscrita);
					
					novoAluno.setNomeCompleto(nomeCompletoInformado);
					novoAluno.setMatricula(matriculaInformada);
					
					isContinuar = true;
					AlunoRepository.salvarAluno(novoAluno);
					
					return novoAluno;
				} catch (VerificarLiteralException e) {
					System.out.println(e.getMessage());
				} catch (VerificarInteiroException e) {
					System.out.println(e.getMessage());	
				}
			} while (!isContinuar);
		
		return null;
	}

	private static List<Materia> cadastrarMaterias(Aluno aluno) {
		boolean isContinuar = false;
		do {
			try {
				List<Materia> materias = new ArrayList<>();

				System.out.println("Informe a nota e a quantidade de falta em cada matéria:");

				String[] materiasEscritas = new String[] {
						"Biologia", "Matemática", "Geografia", "História", "Educação Física",
						"Língua Estrangeira - Inglês", "Língua Portuguesa", "Sociologia", 
						"Física", "Química", "Filosofia", "Arte" };

				for (String materia : materiasEscritas) {

					Materia novaMateria = new Materia();

					novaMateria.setNome(materia);

					System.out.println("Nota de " + materia + ":");
	                String notaInformadaEscrita = sc.next();
					
					if (!(notaInformadaEscrita.matches("[0-9]{1,2}") || notaInformadaEscrita.matches("^[0-9]{1,2}.[0-9]{1}")) ) {
						throw new VerificarDecimalNotaException(
								"Erro! A nota deve ser um número inteiro positivo ou um decimal com um número após a virgula.");
					}
					
					double notaInformada = Double.valueOf(notaInformadaEscrita);
					
				    if (notaInformada > 10) {
						throw new VerificarDecimalNotaException(
								"Erro! A nota não pode ser maior que 10.");
					}
					
					System.out.println("Quantidade de faltas de " + materia + ":");
					String qtdeFaltasInformadaEscrita = sc.next();
					
					if (!qtdeFaltasInformadaEscrita.matches("[0-9]{1,2}")) {
						throw new VerificarInteiroException(
								"Erro! A quantidade de faltas deve ser um inteiro positivo.");
					}
					
					int qtdeFaltaInformada = Integer.valueOf(qtdeFaltasInformadaEscrita);
					
					novaMateria.setNota(notaInformada);
					novaMateria.setQtdeDeFalta(qtdeFaltaInformada);
					materias.add(novaMateria);
					MateriaRepository.salvarMateria(novaMateria);
				}
				
				isContinuar = true;
				
				return materias;
			} catch (VerificarDecimalNotaException e) {
				System.out.println(e.getMessage());
			} catch (VerificarInteiroException e) {
				System.out.println(e.getMessage());	
			} catch (NullPointerException e) {
				System.out.println("Campo obrigatório.");
			}
		} while (!isContinuar);
		return null;
	}

	private static Boletim criarBoletim(Aluno aluno, List<Materia> materias) {
		boolean isContinuar = false;
		do {
			try {
				Boletim novoBoletim = new Boletim();

				novoBoletim.setAluno(aluno);
				novoBoletim.setMaterias(materias);

				System.out.println("Informe a unidade escolar:");
				String unidadeEscolarInformada = sc.next();

				if (!unidadeEscolarInformada.matches("[A-Za-zÀ-ú]{2,60}")) {
					throw new VerificarLiteralException(
							"Erro! A unidade escolar deve ter entre 2 e 60 caracteres literais.");
				}

				System.out.println("Informe o municipio:");
				String municipioInformado = sc.next();

				if (!municipioInformado.matches("[A-Za-zÀ-ú]{2,60}")) {
					throw new VerificarLiteralException(
							"Erro! O municipio deve ter entre 2 e 60 caracteres literais.");
				}

				System.out.println("Informe a etapa:");
	            String etapaInformadaEscrita = sc.next();
				
				if (!etapaInformadaEscrita.matches("[0-9]{1}")) {
					throw new VerificarInteiroException(
							"Erro! A etapa deve ser um inteiro positivo.");
				}
				
				int etapaInformada = Integer.valueOf(etapaInformadaEscrita);

				System.out.println("Informe a turma:");
	            String turmaInformadaEscrita = sc.next();
				
				if (!turmaInformadaEscrita.matches("[0-9]{1}")) {
					throw new VerificarInteiroException(
							"Erro! A turma deve ser um inteiro positivo.");
				}
				
				int turmaInformada = Integer.valueOf(turmaInformadaEscrita);

				System.out.println("Informe o turno:");
	            String turnoInformado = sc.next();
				
	            if (!turnoInformado.matches("[A-Za-zÀ-ú]{2,60}")) {
					throw new VerificarLiteralException(
							"Erro! O turno deve ser um inteiro positivo.");
				}

				System.out.println("Informe a avaliação:");
	            String avaliacaoInformadaEscrita = sc.next();
				
				if (!avaliacaoInformadaEscrita.matches("[0-9]{1}")) {
					throw new VerificarInteiroException(
							"Erro! A avaliação deve ser um inteiro positivo.");
				}
				
				int avaliacaoInformada = Integer.valueOf(avaliacaoInformadaEscrita);

				novoBoletim.setUnidadeEscolar(unidadeEscolarInformada);
				novoBoletim.setMunicipio(municipioInformado);
				novoBoletim.setEtapa(etapaInformada);
				novoBoletim.setTurma(turmaInformada);
				novoBoletim.setTurno(turnoInformado);
				novoBoletim.setAvaliacao(avaliacaoInformada);
				novoBoletim.setAno(LocalDate.now().getYear());

				isContinuar = true;
				BoletimRepository.salvarBoletim(novoBoletim);
				return novoBoletim;
			} catch (VerificarLiteralException e) {
				System.out.println(e.getMessage());
			} catch (VerificarInteiroException e) {
				System.out.println(e.getMessage());	
			} catch (NullPointerException e) {
				System.out.println("Campo obrigatório.");
			}
		} while (!isContinuar);
		return null;
	}

//	private static String gerarBoletimEscrito(Boletim boletim) {
//		int qtdeCaracter = 0;
//		String boletimEscrito = """
//				UNIDADE ESCOLAR: %s
//				MUNICÍPIO: %s
//				CURSO: %s
//				TURNO: %s
//				ETAPA: %d
//				TURMA: %d
//				ALUNO: %d - %s
//				""";
//				;
//		
//		return boletimEscrito;
//	}
}