CREATE TABLE matricula(
    id UUID PRIMARY KEY,
    aluno_id UUID REFERENCES aluno(id),
    unidade_escolar VARCHAR(100) NOT NULL,
    municipio VARCHAR(100) NOT NULL,
    etapa INT NOT NULL,
    turma INT NOT NULL,
    turno VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL
);
