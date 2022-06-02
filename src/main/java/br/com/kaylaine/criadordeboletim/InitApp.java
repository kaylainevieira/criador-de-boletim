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
import br.com.kaylaine.criadordeboletim.repository.BoletimRepository;

public class InitApp {

	public static final int QTDE_TOTAL_CARACTERES = 80;

	public static final int QTDE_METADE_CARACTERES = 36;

	public static final int QTDE_ESPACOS_LINHA1 = 20;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String opcaoDeMenu = "";
		do {
			try {
				gerarTextoDeMenu();
				opcaoDeMenu = "4";
				opcaoDeMenu = sc.next();

				if (!opcaoDeMenu.matches("[0-9]{1}")) {
					throw new VerificarInteiroException("Opção inválida. Digite um número de 1 à 4.");
				}

				int opcaoDeMenuInformada = Integer.valueOf(opcaoDeMenu);

				Aluno novoAluno = new Aluno();
				List<Materia> materias = new ArrayList<Materia>();
				Boletim boletim = new Boletim();

				if (opcaoDeMenuInformada == 1) {

//					novoAluno = perguntarInformaçõesAluno();
//					materias = cadastrarMaterias(novoAluno);
//					boletim = criarBoletim(novoAluno, materias);
//					
//					BoletimRepository.salvar(boletim);
					boletim = criarBoletimExemplo();
					BoletimRepository.salvar(boletim);

				} else if (opcaoDeMenuInformada == 2) {
					System.out.println("Informe a matricula do aluno que deseja mostrar:");
					int matriculaParaMostrar = sc.nextInt();

					Boletim boletimParaMostrar = new Boletim();
					boletimParaMostrar = BoletimRepository.mostrarPor(matriculaParaMostrar);
					System.out.println(gerarBoletimEscrito(boletimParaMostrar));

				} else if (opcaoDeMenuInformada == 3) {
					System.out.println("Informe a matricula do aluno que deseja remover:");
					int matriculaParaExcluir = sc.nextInt();
					
					if (BoletimRepository.removerPor(matriculaParaExcluir)) {
						System.out.println("Boletim removido com sucesso.");
					} else {
						System.out.println("Boletim não encontrado.");
					}

				} else if (opcaoDeMenuInformada == 4) {
					System.out.println("Aplicação encerrada.");

				} else {
					System.out.println("Opção inválida.");
				}

			} catch (VerificarInteiroException e) {
				System.out.println("Opção inválida.");
			} catch (NullPointerException e) {
				System.out.println("Boletim não encontrado.");
			}

		} while (!opcaoDeMenu.equalsIgnoreCase("4"));

		sc.close();
	}

	private static Boletim criarBoletimExemplo() {
		Aluno aluno1 = new Aluno(55, "Maria dos Santos");

		List<Materia> materias = new ArrayList<Materia>();

		String[] materiasEscritas = new String[] { "Biologia", "Matemática", "Geografia", "História", "Educação Física",
				"Língua Estrangeira - Inglês", "Língua Portuguesa", "Sociologia", "Física", "Química", "Filosofia",
				"Arte" };

		for (String materia : materiasEscritas) {

			Materia novaMateria = new Materia(10, 4);
			novaMateria.setNome(materia);
			materias.add(novaMateria);
		}

		Boletim boletim = new Boletim(aluno1, materias, "Henrique Fontes", "Tubarão", 1, 8, "NOTURNO", "Ensino Médio",
				2020, 1);
		return boletim;
	}

	private static void gerarTextoDeMenu() {
		System.out.println("""

				Informe:
				1 - Cadastrar boletim.
				2 - Mostrar boletim.
				3 - Excluir boletim.
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

				if (!matriculaInformadaEscrita.matches("[0-9]{6}")) {
					throw new VerificarInteiroException("Erro! A matricula deve ter 10 caracteres inteiros positivo.");
				}

				int matriculaInformada = Integer.valueOf(matriculaInformadaEscrita);

				novoAluno.setNomeCompleto(nomeCompletoInformado);
				novoAluno.setMatricula(matriculaInformada);

				isContinuar = true;

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

				String[] materiasEscritas = new String[] { "Biologia", "Matemática", "Geografia", "História",
						"Educação Física", "Língua Estrangeira - Inglês", "Língua Portuguesa", "Sociologia", "Física",
						"Química", "Filosofia", "Arte" };

				for (String materia : materiasEscritas) {

					Materia novaMateria = new Materia();

					novaMateria.setNome(materia);

					System.out.println("Nota de " + materia + ":");
					String notaInformadaEscrita = sc.next();

					if (!(notaInformadaEscrita.matches("[0-9]{1,2}")
							|| notaInformadaEscrita.matches("^[0-9]{1,2}.[0-9]{1}"))) {
						throw new VerificarDecimalNotaException(
								"Erro! A nota deve ser um número inteiro positivo ou um decimal com um número após a virgula.");
					}

					double notaInformada = Double.valueOf(notaInformadaEscrita);

					if (notaInformada > 10) {
						throw new VerificarDecimalNotaException("Erro! A nota não pode ser maior que 10.");
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
					throw new VerificarLiteralException("Erro! O municipio deve ter entre 2 e 60 caracteres literais.");
				}

				System.out.println("Informe o curso:");
				String cursoInformado = sc.next();

				if (!cursoInformado.matches("[A-Za-zÀ-ú]{2,60}")) {
					throw new VerificarLiteralException("Erro! O curso deve ter entre 2 e 60 caracteres literais.");
				}

				System.out.println("Informe a etapa:");
				String etapaInformadaEscrita = sc.next();

				if (!etapaInformadaEscrita.matches("[0-9]{1}")) {
					throw new VerificarInteiroException("Erro! A etapa deve ser um inteiro positivo.");
				}

				int etapaInformada = Integer.valueOf(etapaInformadaEscrita);

				System.out.println("Informe a turma:");
				String turmaInformadaEscrita = sc.next();

				if (!turmaInformadaEscrita.matches("[0-9]{1}")) {
					throw new VerificarInteiroException("Erro! A turma deve ser um inteiro positivo.");
				}

				int turmaInformada = Integer.valueOf(turmaInformadaEscrita);

				System.out.println("Informe o turno:");
				String turnoInformado = sc.next();

				if (!turnoInformado.matches("[A-Za-zÀ-ú]{2,60}")) {
					throw new VerificarLiteralException("Erro! O turno deve ser um inteiro positivo.");
				}

				System.out.println("Informe a avaliação:");
				String avaliacaoInformadaEscrita = sc.next();

				if (!avaliacaoInformadaEscrita.matches("[0-9]{1}")) {
					throw new VerificarInteiroException("Erro! A avaliação deve ser um inteiro positivo.");
				}

				int avaliacaoInformada = Integer.valueOf(avaliacaoInformadaEscrita);

				novoBoletim.setUnidadeEscolar(unidadeEscolarInformada);
				novoBoletim.setMunicipio(municipioInformado);
				novoBoletim.setEtapa(etapaInformada);
				novoBoletim.setTurma(turmaInformada);
				novoBoletim.setCurso(cursoInformado);
				novoBoletim.setTurno(turnoInformado);
				novoBoletim.setAvaliacao(avaliacaoInformada);
				novoBoletim.setAno(LocalDate.now().getYear());

				isContinuar = true;
				BoletimRepository.salvar(novoBoletim);
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

	private static String gerarBoletimEscrito(Boletim boletim) {
		String boletimEscrito = "";

		for (int i = 0; i < QTDE_TOTAL_CARACTERES; i++) {
			boletimEscrito = boletimEscrito + "-";
		}

		boletimEscrito = boletimEscrito + "\nUnidade Escolar:";

		for (int i = 0; i < QTDE_ESPACOS_LINHA1; i++) {
			boletimEscrito = boletimEscrito + " ";
		}

		boletimEscrito = boletimEscrito + "Municipio:";

		boletimEscrito = boletimEscrito + "\n" + boletim.getUnidadeEscolar();

		for (int i = 0; i < (QTDE_METADE_CARACTERES - boletim.getUnidadeEscolar().length()); i++) {
			boletimEscrito = boletimEscrito + " ";
		}

		boletimEscrito = boletimEscrito + boletim.getMunicipio();

		boletimEscrito = boletimEscrito + "\n";
		for (int i = 0; i < QTDE_TOTAL_CARACTERES; i++) {
			boletimEscrito = boletimEscrito + "-";
		}

		boletimEscrito = boletimEscrito + "\nCurso:";

		for (int i = 0; i < (QTDE_METADE_CARACTERES - "Curso:".length()); i++) {
			boletimEscrito = boletimEscrito + " ";
		}

		boletimEscrito = boletimEscrito + "Turno:\t\tEtapa:\t\tTurma";

		boletimEscrito = boletimEscrito + "\n" + "curso";

		for (int i = 0; i < (QTDE_METADE_CARACTERES - "curso".length()); i++) {
			boletimEscrito = boletimEscrito + " ";
		}

		boletimEscrito = boletimEscrito + boletim.getTurno() + "\t\t" + boletim.getEtapa() + "\t\t"
				+ boletim.getEtapa();

		boletimEscrito = boletimEscrito + "\n";
		for (int i = 0; i < QTDE_TOTAL_CARACTERES; i++) {
			boletimEscrito = boletimEscrito + "-";
		}

		boletimEscrito = boletimEscrito + "\nAluno:";

		for (int i = 0; i < (QTDE_METADE_CARACTERES - "Aluno:".length()); i++) {
			boletimEscrito = boletimEscrito + " ";
		}

		boletimEscrito = boletimEscrito + "\n" + boletim.getAluno().getMatricula() + " - "
				+ boletim.getAluno().getNomeCompleto();

		boletimEscrito = boletimEscrito + "\n";
		for (int i = 0; i < QTDE_TOTAL_CARACTERES; i++) {
			boletimEscrito = boletimEscrito + "-";
		}

		boletimEscrito = boletimEscrito + "\nDisciplina:";

		for (int i = 0; i < (QTDE_METADE_CARACTERES - "Disciplina:".length()); i++) {
			boletimEscrito = boletimEscrito + " ";
		}

		boletimEscrito = boletimEscrito + boletim.getAvaliacao() + "° Avaliação";

		boletimEscrito = boletimEscrito + "\n";

		for (int i = 0; i < (QTDE_METADE_CARACTERES); i++) {
			boletimEscrito = boletimEscrito + " ";
		}

		boletimEscrito = boletimEscrito + "Nota   Falta";

		for (Materia materia : boletim.getMaterias()) {

			boletimEscrito = boletimEscrito + "\n" + materia.getNome();

			for (int i = 0; i < (QTDE_METADE_CARACTERES - materia.getNome().length()); i++) {
				boletimEscrito = boletimEscrito + " ";
			}

			boletimEscrito = boletimEscrito + materia.getNota() + "     " + materia.getQtdeDeFalta();
		}

		boletimEscrito = boletimEscrito + "\n";
		for (int i = 0; i < QTDE_TOTAL_CARACTERES; i++) {
			boletimEscrito = boletimEscrito + "-";
		}

		return boletimEscrito;
	}
}