package br.com.kaylaine.criadordeboletim.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.kaylaine.criadordeboletim.entity.Aluno;

public class AlunoRepository {

	private static final List<Aluno> alunos = new ArrayList<>();
	
	private static int id = 0;
	
	public static Aluno salvar(Aluno aluno) {
		aluno.setId(id);
		AlunoRepository.alunos.add(aluno);
		id++;
		return aluno;
	}
	
	
}
