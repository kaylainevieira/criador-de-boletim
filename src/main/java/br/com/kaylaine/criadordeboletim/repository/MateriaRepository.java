package br.com.kaylaine.criadordeboletim.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.kaylaine.criadordeboletim.entity.Materia;

public class MateriaRepository {

private static final List<Materia> materias = new ArrayList<>();

	private static int id = 0;
	
	public static Materia salvar(Materia materia) {
		materia.setId(id);
		MateriaRepository.materias.add(materia);
		id++;
		return materia;
	}
}
