CREATE TABLE nota(
    id UUID PRIMARY KEY,
    aluno_id UUID REFERENCES aluno(id),
    materia_id UUID REFERENCES materia(id),
    valor NUMERIC(10,2),
    avaliacao INT,
    data TIMESTAMP
);
