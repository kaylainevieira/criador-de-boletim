create function atualiza_historico_fc() returns trigger
    language plpgsql
as
$$
BEGIN
        IF (TG_OP = 'INSERT') THEN
INSERT INTO historico (tabela, data) VALUES (TG_TABLE_NAME::text, NOW());
END IF;
        IF (TG_OP = 'UPDATE') THEN
INSERT INTO historico (tabela, data) VALUES (TG_TABLE_NAME::text, NOW());
END IF;

     IF (TG_OP = 'DELETE') THEN
INSERT INTO historico (tabela, data) VALUES (TG_TABLE_NAME::text, NOW());
END IF;

RETURN NEW;
END;
$$;

CREATE TRIGGER atualiza_aluno_tg AFTER UPDATE OR INSERT OR DELETE
ON aluno FOR EACH ROW
EXECUTE PROCEDURE atualiza_historico_fc();

CREATE TRIGGER atualiza_materia_tg AFTER UPDATE OR INSERT OR DELETE
ON materia FOR EACH ROW
EXECUTE PROCEDURE atualiza_historico_fc();

CREATE TRIGGER atualiza_nota_tg AFTER UPDATE OR INSERT OR DELETE
ON nota FOR EACH ROW
EXECUTE PROCEDURE atualiza_historico_fc();

CREATE TRIGGER atualiza_matricula_tg AFTER UPDATE OR INSERT OR DELETE
ON matricula FOR EACH ROW
EXECUTE PROCEDURE atualiza_historico_fc();

