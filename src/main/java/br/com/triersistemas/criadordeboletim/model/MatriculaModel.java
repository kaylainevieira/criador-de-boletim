package br.com.triersistemas.criadordeboletim.model;

import br.com.triersistemas.criadordeboletim.entity.Materia;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class MatriculaModel {

    private UUID idAluno;

    private String unidadeEscolar;

    private String municipio;

    private Integer etapa;

    private Integer turma;

    private String turno;

    private String curso;

    private Integer avaliacao;
}
