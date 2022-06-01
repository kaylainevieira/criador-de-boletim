package br.com.kaylaine.criadordeboletim.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.kaylaine.criadordeboletim.entity.Boletim;

public class BoletimRepository {

private static final List<Boletim> boletins = new ArrayList<>();
	
	private static int id = 0;
	
	public static Boletim salvar(Boletim boletim) {
		boletim.setId(id);
		BoletimRepository.boletins.add(boletim);
		id++;
		return boletim;
	}
}
