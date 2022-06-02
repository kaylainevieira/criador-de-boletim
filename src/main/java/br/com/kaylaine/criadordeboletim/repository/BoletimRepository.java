package br.com.kaylaine.criadordeboletim.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.kaylaine.criadordeboletim.entity.Boletim;

public class BoletimRepository {

private static final List<Boletim> boletins = new ArrayList<>();
	
	private static int id = 0;
	
	public static Boletim salvar(Boletim boletim) {
		boletim.setId(id);
		boletins.add(boletim);
		id++;
		return boletim;
	}
	
	public static Boletim mostrarPor(Integer matricula) {
		return boletins.stream().filter(it -> matricula.equals(it.getAluno().getMatricula())).findFirst().orElse(null);
	}
	
	public static boolean removerPor(Integer matricula) {
		Optional<Boletim> boletim = boletins.stream().filter(it -> matricula.equals(it.getAluno().getMatricula())).findFirst();
		
		if (boletim.isPresent()) {
			boletins.remove(boletim.get());
			return true;
		}
		
		return false;
	}
}