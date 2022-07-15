package br.com.triersistemas.criadordeboletim.repository.impl;

import br.com.triersistemas.criadordeboletim.domain.Materia;
import br.com.triersistemas.criadordeboletim.domain.QMateria;
import br.com.triersistemas.criadordeboletim.repository.MateriaRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MateriaRepositoryImpl implements MateriaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Materia> listarPorNome(String nome) {
        final QMateria materia = QMateria.materia;

        BooleanBuilder where = new BooleanBuilder();
        where.and(materia.nome.containsIgnoreCase(nome));

        return new JPAQuery<Materia>(em)
                .select(materia)
                .from(materia)
                .where(where)
                .fetch();
    }

}
